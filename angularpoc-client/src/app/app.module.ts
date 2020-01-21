import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { MaterialModule } from './modules/material.module';
import {
  DateAdapter,
  MAT_DATE_FORMATS,
  MAT_DATE_LOCALE
} from '@angular/material'
import {
  MomentDateAdapter
} from '@angular/material-moment-adapter';

//BBDD MOCK
//import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
//import { InMemoryDataService }  from './in-memory-data.service';

import { RectifDataComponent } from './rectif-data/rectif-data.component';
import { ClientComponent } from './client/client.component';
import { RectifListComponent } from './rectif-list/rectif-list.component';

import { UserInterceptor } from './helper/user.interceptor';



//create our cost var with the information about the format that we want 
export const MY_FORMATS = {
  parse: {
      dateInput: 'DD/MM/YYYY',
  },
  display: {
      dateInput: 'DD/MM/YYYY',
      monthYearLabel: 'MM YYYY',
      dateA11yLabel: 'DD/MM/YYYY',
      monthYearA11yLabel: 'MM YYYY',
  },
};

@NgModule({
  declarations: [
    AppComponent,
    RectifDataComponent,
    ClientComponent,
    RectifListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MaterialModule,
    // The HttpClientInMemoryWebApiModule module intercepts HTTP requests
    // and returns simulated server responses.
    // Remove it when a real server is ready to receive requests.
    //HttpClientInMemoryWebApiModule.forRoot(InMemoryDataService, { dataEncapsulation: false })
  ],
  providers: [
    {
    provide: MAT_DATE_LOCALE,
    useValue: 'es'
    },
    //you can change
    {
    provide: DateAdapter,
    useClass: MomentDateAdapter,
    deps: [MAT_DATE_LOCALE]
    },
    {
    provide: MAT_DATE_FORMATS,
    useValue: MY_FORMATS
    },
    {
      provide: HTTP_INTERCEPTORS, useClass: UserInterceptor, multi: true
    }
  ],
  bootstrap: [AppComponent]
})

export class AppModule { 

}