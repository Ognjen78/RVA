import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Sala } from '../models/sala';
import { SALA_URL } from 'src/constrants';

@Injectable({
  providedIn: 'root',
})
export class SalaService {
  constructor(private httpClient: HttpClient) {}

  public getAllSalas(): Observable<any> {
    return this.httpClient.get(`${SALA_URL}`);
  }

  public addSala(sala: Sala): Observable<any> {
    return this.httpClient.post(`${SALA_URL}`, sala);
  }

  public updateSala(sala: Sala): Observable<any> {
    return this.httpClient.put(`${SALA_URL}/${sala.id}`, sala);
  }

  public deleteSala(id: number): Observable<any> {
    return this.httpClient.delete(`${SALA_URL}/${id}`);
  }
}
