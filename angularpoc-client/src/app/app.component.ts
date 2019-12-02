import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'RECTIFICATION FISCALE';

  /** Log a HeroService message with the MessageService */
  public log(message: string) {
    console.log(message);
  }
}
