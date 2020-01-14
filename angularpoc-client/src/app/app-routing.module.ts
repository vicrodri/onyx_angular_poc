import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RectifDataComponent } from './rectif-data/rectif-data.component';

const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full'} , 
  { path: 'rectifCoupons_creer', component: RectifDataComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }