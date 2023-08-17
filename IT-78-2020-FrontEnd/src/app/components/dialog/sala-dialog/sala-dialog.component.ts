import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Bioskop } from 'src/app/models/bioskop';
import { Sala } from 'src/app/models/sala';
import { BioskopService } from 'src/app/service/bioskop.service';
import { SalaService } from 'src/app/service/sala.service';

@Component({
  selector: 'app-sala-dialog',
  templateUrl: './sala-dialog.component.html',
  styleUrls: ['./sala-dialog.component.css'],
})
export class SalaDialogComponent implements OnInit {
  flag!: number;
  bioskop!: Bioskop[];

  constructor(
    public snackBar: MatSnackBar,
    public salaService: SalaService,
    @Inject(MAT_DIALOG_DATA) public data: Sala,
    public dialogRef: MatDialogRef<Sala>,
    public bioskopService: BioskopService
  ) {}

  ngOnInit(): void {
    this.bioskopService.getAllBioskops().subscribe((data) => {
      this.bioskop = data;
    });
  }

  public compare(a: any, b: any) {
    return a.id == b.id;
  }

  public add(): void {
    this.salaService.addSala(this.data).subscribe(() => {
      this.snackBar.open(
        'Sala sa nazivom: ' + this.data.id + ' je uspesno dodat!',
        'OK',
        { duration: 4500 }
      );
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open('Dogodila se greska!', 'OK', { duration: 4500 });
      };
  }

  public update(): void {
    this.salaService.updateSala(this.data).subscribe(() => {
      this.snackBar.open(
        'Sala sa ID: ' + this.data.id + ' je uspesno izmenjen!',
        'OK',
        { duration: 4500 }
      );
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open('Dogodila se greska!', 'OK', { duration: 4500 });
      };
  }

  public delete(): void {
    this.salaService.deleteSala(this.data.id).subscribe(() => {
      this.snackBar.open('Sala je uspesno izbrisan!', 'OK', { duration: 4500 });
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open('Dogodila se greska!', 'OK', { duration: 4500 });
      };
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste od izmena', 'OK', { duration: 4500 });
  }
}
