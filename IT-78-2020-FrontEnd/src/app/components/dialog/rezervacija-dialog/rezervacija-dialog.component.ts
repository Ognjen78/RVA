import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Film } from 'src/app/models/film';
import { Rezervacija } from 'src/app/models/rezervacija';
import { FilmService } from 'src/app/service/film.service';
import { RezervacijaService } from 'src/app/service/rezervacija.service';

@Component({
  selector: 'app-rezervacija-dialog',
  templateUrl: './rezervacija-dialog.component.html',
  styleUrls: ['./rezervacija-dialog.component.css'],
})
export class RezervacijaDialogComponent {
  flag!: number;
  films!: Film[];

  constructor(
    public snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<Rezervacija>,
    @Inject(MAT_DIALOG_DATA) public data: Rezervacija,
    public rezervacijaService: RezervacijaService,
    public filmService: FilmService
  ) {}

  ngOnInit(): void {
    this.filmService.getAllFilms().subscribe((data) => {
      this.films = data;
    });
  }

  public compare(a: any, b: any) {
    return a.id == b.id;
  }

  public add(): void {
    this.rezervacijaService.addRezervacija(this.data).subscribe(() => {
      this.snackBar.open('Rezervacija je uspesno dodata!', 'Ok', {
        duration: 4500,
      });
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open('Dogodila se greska', 'Ok', { duration: 2500 });
      };
  }

  public update(): void {
    this.rezervacijaService.updateRezervacija(this.data).subscribe(() => {
      this.snackBar.open(
        'Rezervacija sa ID: ' + this.data.id + ' je uspesno izmenjena!',
        'Ok',
        { duration: 4500 }
      );
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open('Dogodila se greska', 'Ok', { duration: 2500 });
      };
  }

  public delete(): void {
    this.rezervacijaService.deleteRezervacija(this.data.id).subscribe(() => {
      this.snackBar.open('Rezervacija je izbrisana!', 'Ok', { duration: 4500 });
    }),
      (error: Error) => {
        console.log(error.name + ' ' + error.message);
        this.snackBar.open('Dogodila se greska', 'Ok', { duration: 2500 });
      };
  }

  public cancel(): void {
    this.dialogRef.close();
    this.snackBar.open('Odustali ste od izmena', 'Ok', { duration: 2500 });
  }
}
