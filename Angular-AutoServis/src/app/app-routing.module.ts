import { KvarCreateComponent } from './kvarovi/kvarovi-create/kvar-create.component';
import { KvaroviComponent } from './kvarovi/kvarovi.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KvarDetailComponent } from './kvarovi/kvarovi-detail/kvar-detail.component';

import { KlijentiComponent } from './klijenti/klijenti.component';
import { KlijentDetailComponent } from './klijenti/klijent-detail/klijent-detail.component';
import { KlijentCreateComponent } from './klijenti/klijent-create/klijent-create.component';
import { KlijentEditComponent } from './klijenti/klijent-edit/klijent-edit.component';

import { MjestaComponent } from './mjesta/mjesta.component';

import { RadniciComponent} from "./radnici/radnici.component";
import { RadnikCreateComponent} from "./radnici/radnik-create/radnik-create.component";

import { ForbiddenPageComponent } from './forbidden-page/forbidden-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {KvarEditComponent} from "./kvarovi/kvarovi-edit/kvar-edit.component";

const routes: Routes = [
  {
    path: 'klijenti',
    component: KlijentiComponent,
  },
  {
    path: 'klijent/detail/:id',
    component: KlijentDetailComponent,
  },
  {
    path: 'klijent/create',
    component: KlijentCreateComponent
  },
  {
    path: 'klijent/edit/:id',
    component: KlijentEditComponent,
  },
  {
    path: 'mjesta',
    component: MjestaComponent,
  },
  {
    path: 'kvarovi',
    component: KvaroviComponent,
  },
  {
    path: 'kvar/detail/:id',
    component: KvarDetailComponent,
  },
  {
    path: 'kvar/create',
    component: KvarCreateComponent
  },
  {
    path: 'kvar/edit/:id',
    component: KvarEditComponent,
  },
  {
    path: 'radnici',
    component: RadniciComponent,
  },
  {
    path: 'radnik/create',
    component: RadnikCreateComponent,
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
