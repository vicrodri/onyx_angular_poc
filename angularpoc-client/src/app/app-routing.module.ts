import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RectifDataComponent } from './rectif-data/rectif-data.component';
import { RectifMainComponent } from './rectif-main/rectif-main.component';

const routes: Routes = [
  { path: '', redirectTo: '/rectif', pathMatch: 'full'} , 
  { path: 'rectif', component: RectifMainComponent } , 
  { path: 'rectifCoupons_creer', component: RectifDataComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }