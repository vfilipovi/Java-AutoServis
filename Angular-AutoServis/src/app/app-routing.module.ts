import { KvarCreateComponent } from './kvar/kvarovi-create/kvar-create.component';
import { KvaroviComponent } from './kvar/kvarovi.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KvarDetailComponent } from './kvar/kvarovi-detail/kvar-detail.component';

import { KlijentiComponent } from './klijenti/klijenti.component';
import { KlijentDetailComponent } from './klijenti/klijent-detail/klijent-detail.component';
import { KlijentCreateComponent } from './klijenti/klijent-create/klijent-create.component';
import { KlijentEditComponent } from './klijenti/klijent-edit/klijent-edit.component';

import { MjestaComponent } from './mjesta/mjesta.component';

import { ForbiddenPageComponent } from './forbidden-page/forbidden-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {KvarEditComponent} from "./kvar/kvarovi-edit/kvar-edit.component";

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
