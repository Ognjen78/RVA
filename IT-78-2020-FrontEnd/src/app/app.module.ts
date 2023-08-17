import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

import { MatGridListModule } from '@angular/material/grid-list';
import { MatExpansionModule } from '@angular/material/expansion';
import { BioskopComponent } from './components/main/bioskop/bioskop.component';
import { FilmComponent } from './components/main/film/film.component';
import { SalaComponent } from './components/main/sala/sala.component';
import { AboutComponent } from './components/utility/about/about.component';
import { HomeComponent } from './components/utility/home/home.component';
import { AuthorComponent } from './components/utility/author/author.component';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { BioskopDialogComponent } from './components/dialog/bioskop-dialog/bioskop-dialog.component';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { SalaDialogComponent } from './components/dialog/sala-dialog/sala-dialog.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { RezervacijaComponent } from './components/main/rezervacija/rezervacija.component';
import { FilmDialogComponent } from './components/dialog/film-dialog/film-dialog.component';
import { MatListModule } from '@angular/material/list';
import { MatSidenavModule } from '@angular/material/sidenav';
import { RezervacijaDialogComponent } from './components/dialog/rezervacija-dialog/rezervacija-dialog.component';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';

@NgModule({
  declarations: [
    AppComponent,
    BioskopComponent,
    FilmComponent,
    SalaComponent,
    AboutComponent,
    HomeComponent,
    AuthorComponent,
    BioskopDialogComponent,
    SalaDialogComponent,
    RezervacijaComponent,
    FilmDialogComponent,
    RezervacijaDialogComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatGridListModule,
    MatExpansionModule,
    HttpClientModule,
    MatTableModule,
    MatToolbarModule,
    MatSnackBarModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatListModule,
    MatSidenavModule,
    MatCheckboxModule,
    MatSortModule,
    MatPaginatorModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
