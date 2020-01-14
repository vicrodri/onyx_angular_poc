import { Component, OnInit } from '@angular/core';

import { UserService }  from './user.service';
import { UserInfo } from './model/userInfo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'RECTIFICATION FISCALE';
  userInfo : UserInfo;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userInfo = this.userService.getUserInfo();
  }

  quit() {
    window.alert('Marcho');
    return false;
  }

  openCCM() {
    window.alert('CCM');
    return false;
  }
}
