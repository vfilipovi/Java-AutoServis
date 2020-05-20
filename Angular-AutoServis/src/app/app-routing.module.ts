import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { KlijentiComponent } from './klijenti/klijenti.component';
import { KlijentDetailComponent } from './klijenti/klijent-detail/klijent-detail.component';
import { KlijentCreateComponent } from './klijenti/klijent-create/klijent-create.component';
import { KlijentEditComponent } from './klijenti/klijent-edit/klijent-edit.component';

import { MjestaComponent } from './mjesta/mjesta.component';

import { ForbiddenPageComponent } from './forbidden-page/forbidden-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  {
    path: 'klijenti',
    component: KlijentiComponent,
  },
  {
    path: 'klijenti/detail/:id',
    component: KlijentDetailComponent,
  },
  {
    path: 'klijenti/create',
    component: KlijentCreateComponent
  },
  {
    path: 'klijenti/edit/:id',
    component: KlijentEditComponent,
  },
  {
    path: 'mjesta',
    component: MjestaComponent,
  },
  {
    path: 'forbidden',
    component: ForbiddenPageComponent
  },
  {
    path: '**', component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
