import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { retry, catchError, map, window } from 'rxjs/operators';

import { Client } from './model/client';

@Injectable({
  providedIn: 'root'
})

export class ClientService {

  private mockClientUrl = 'api/clients';  // URL to web api
  private clientUrl = 'http://localhost:8080/angularpoc-rest/api/v1/getClient';  // URL to web api

  constructor(private http: HttpClient) { }

  /** GET hero by id. Will 404 if id not found */
  getClientMock(client: Client): Observable<Client> {
    let url = client ? this.mockClientUrl + `/?agence=${client.agence}` : this.mockClientUrl;
    console.log(url);
    return this.http.get<Client>(url);
  }

  /** GET hero by id. Will 404 if id not found */
  getClient(client: Client): Observable<string> {
    let url = /*client ? this.clientUrl + `/?agence=${client.agence}` : */this.clientUrl;
    console.log(url);
    return this.http.post(url, client, {responseType: 'text', withCredentials: true});
  }
}
