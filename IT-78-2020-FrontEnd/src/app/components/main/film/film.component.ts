import { Component, OnDestroy, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { Subscription } from 'rxjs';
import { Film } from 'src/app/models/film';
import { FilmDialogComponent } from '../../dialog/film-dialog/film-dialog.component';
import { FilmService } from 'src/app/service/film.service';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css'],
})
export class FilmComponent implements OnInit, OnDestroy {
  dataSource!: MatTableDataSource<Film>;
  displayedColumns = [
    'id',
    'naziv',
    'recenzija',
    'trajanje',
    'zanr',
    'actions',
  ];
  subscription!: Subscription;

  constructor(private filmService: FilmService, public dialog: MatDialog) {}
  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  ngOnInit(): void {
    this.loadData();
  }

  public loadData() {
    (this.subscription = this.filmService.getAllFilms().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    })),
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
      };
  }

  public openDialog(
    flag: number,
    id?: number,
    naziv?: string,
    recenzija?: number,
    trajanje?: number,
    zanr?: string
  ): void {
    const dialogRef = this.dialog.open(FilmDialogComponent, {
      data: { id, naziv, recenzija, trajanje, zanr },
    });
    dialogRef.componentInstance.flag = flag;
    dialogRef.afterClosed().subscribe((result) => {
      if (result == 1) {
        this.loadData();
      }
    });
  }
}
