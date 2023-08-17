import {
  Component,
  Input,
  OnInit,
  OnDestroy,
  OnChanges,
  SimpleChanges,
} from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { RezervacijaDialogComponent } from '../../dialog/rezervacija-dialog/rezervacija-dialog.component';
import { Film } from 'src/app/models/film';
import { Rezervacija } from 'src/app/models/rezervacija';
import { RezervacijaService } from 'src/app/service/rezervacija.service';
import { Sala } from 'src/app/models/sala';

@Component({
  selector: 'app-rezervacija',
  templateUrl: './rezervacija.component.html',
  styleUrls: ['./rezervacija.component.css'],
})
export class RezervacijaComponent implements OnInit, OnDestroy, OnChanges {
  dataSource!: MatTableDataSource<Rezervacija>;
  displayedColumns = [
    'id',
    'brojOsoba',
    'cenaKarte',
    'datum',
    'placeno',
    'film',
    'actions',
  ];
  subscription!: Subscription;

  @Input() childSelectedSala!: Sala;

  constructor(
    private rezervacijaService: RezervacijaService,
    public dialog: MatDialog
  ) {}

  ngOnChanges(changes: SimpleChanges): void {
    if (this.childSelectedSala.id) {
      this.loadData();
    }
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  ngOnInit(): void {
    this.loadData();
  }

  public loadData() {
    (this.subscription = this.rezervacijaService
      .getSalaForRezervacija(this.childSelectedSala.id)
      .subscribe((data) => {
        this.dataSource = new MatTableDataSource(data);
        console.log(data);
      })),
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
      };
  }

  public openDialog(
    flag: number,
    id?: number,
    brojOsoba?: number,
    cenaKarte?: number,
    placeno?: boolean,
    datum?: Date,
    film?: Film
  ): void {
    const dialogRef = this.dialog.open(RezervacijaDialogComponent, {
      data: { id, brojOsoba, cenaKarte, placeno, datum, film },
    });
    dialogRef.componentInstance.flag = flag;
    dialogRef.componentInstance.data.sala = this.childSelectedSala;
    dialogRef.afterClosed().subscribe((result) => {
      if (result == 1) {
        this.loadData();
      }
    });
  }
}
