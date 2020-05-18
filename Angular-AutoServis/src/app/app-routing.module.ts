import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KlijentiComponent } from './klijenti/klijenti.component';


const routes: Routes = [
  {
    path: 'klijenti',
    component: KlijentiComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
