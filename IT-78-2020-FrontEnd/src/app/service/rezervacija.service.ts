import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { REZERVACIJA_URL, SALA_REZERVACIJA_URL } from 'src/constrants';
import { Rezervacija } from '../models/rezervacija';

@Injectable({
  providedIn: 'root',
})
export class RezervacijaService {
  constructor(private httpClient: HttpClient) {}

  public getSalaForRezervacija(idSala: number): Observable<any> {
    return this.httpClient.get(`${SALA_REZERVACIJA_URL}/${idSala}`);
  }

  public getAllRezervacija(): Observable<any> {
    return this.httpClient.get(`${REZERVACIJA_URL}`);
  }

  public addRezervacija(rezervacija: Rezervacija): Observable<any> {
    return this.httpClient.post(`${REZERVACIJA_URL}`, rezervacija);
  }

  public updateRezervacija(rezervacija: Rezervacija): Observable<any> {
    return this.httpClient.put(
      `${REZERVACIJA_URL}/${rezervacija.id}`,
      rezervacija
    );
  }

  public deleteRezervacija(id: number): Observable<any> {
    return this.httpClient.delete(`${REZERVACIJA_URL}/${id}`);
  }
}
