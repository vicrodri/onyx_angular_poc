import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { retry, catchError, map, window } from 'rxjs/operators';

import { Client } from './model/client';

@Injectable({
  providedIn: 'root'
})

export class ClientService {

  private clientUrl = 'api/clients';  // URL to web api

  constructor(private http: HttpClient) { }

  /** GET hero by id. Will 404 if id not found */
  getClient(client: Client): Observable<Client> {
    let url = client ? this.clientUrl + `/?agence=${client.agence}` : this.clientUrl;
    console.log(url);
    return this.http.get<Client>(url);
  }

}
