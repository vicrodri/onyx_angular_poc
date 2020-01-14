import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { UserInfo } from './model/userInfo';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userInfo : UserInfo;

  constructor(private http: HttpClient) { }

  private loadUserInfo() {
    this.userInfo = new UserInfo();
    this.userInfo.matricule = (this.getUrlParameter('matricule') ? this.getUrlParameter('matricule') : '999452282');
    this.userInfo.numRL = (this.getUrlParameter('numRL') ? this.getUrlParameter('numRL') : '1610');
    this.userInfo.omf = (this.getUrlParameter('omf') ? this.getUrlParameter('omf') : '479');
  }

  getUserInfo() : UserInfo {
    if (!this.userInfo) {
      this.loadUserInfo();
    }
    return this.userInfo;
  }

  private getUrlParameter(sParam) { 
    return decodeURIComponent(window.location.search.substring(1)).split('&') 
            .map((v) => { return v.split("=") }) 
            .filter((v) => { return (v[0] === sParam) ? true : false }) 
            .reduce((acc:any,curr:any) => { return curr[1]; }, undefined);
  };

  private init() {

  }


}
