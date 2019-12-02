import { Component, OnInit } from '@angular/core';
import { Compte } from '../model/compte';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit {

  compte: Compte;

  constructor() { }

  ngOnInit() {
  }

}
