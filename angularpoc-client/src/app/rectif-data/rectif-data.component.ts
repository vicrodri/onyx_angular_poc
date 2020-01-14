import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rectif-data',
  templateUrl: './rectif-data.component.html',
  styleUrls: ['./rectif-data.component.css']
})
export class RectifDataComponent implements OnInit {

  showList: boolean = false;

  constructor() { }

  ngOnInit() {
    this.showList = false;
  }

  next() {
    window.alert('Toy continuando');
    this.showList = true;
  }
}
