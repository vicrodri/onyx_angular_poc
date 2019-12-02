import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rectif-data',
  templateUrl: './rectif-data.component.html',
  styleUrls: ['./rectif-data.component.css']
})
export class RectifDataComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  search() {
    window.alert('Toy buscando');
  }
}
