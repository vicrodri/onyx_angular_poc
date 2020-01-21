import { Component, OnInit } from '@angular/core';

import { Client } from '../model/client';
import { ClientService }  from '../client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  client: Client = new Client();

  constructor(private clientService: ClientService) { }

  ngOnInit() {
    
  }

  getClient(): void {
    window.console.log(JSON.stringify(this.client));
    this.clientService.getClient(this.client).subscribe(result$ =>  {
      window.console.log('hago: ' + JSON.stringify(result$));
      this.client.name = result$ ? result$ : this.client.name;
      window.console.log('hice: ' + JSON.stringify(this.client));
   });
    
  }

}
