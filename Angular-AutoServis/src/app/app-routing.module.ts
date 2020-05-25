import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { KlijentiComponent } from './klijenti/klijenti.component';
import { KlijentDetailComponent } from './klijenti/klijent-detail/klijent-detail.component';
import { KlijentCreateComponent } from './klijenti/klijent-create/klijent-create.component';
import { KlijentEditComponent } from './klijenti/klijent-edit/klijent-edit.component';

import { RadniciComponent} from './radnici/radnici.component';
import { RadnikDetailComponent} from './radnici/radnik-detail/radnik-detail.component';
import { RadnikCreateComponent} from './radnici/radnik-create/radnik-create.component';
import { RadnikEditComponent } from './radnici/radnik-edit/radnik-edit.component';

import { KvaroviComponent } from './kvarovi/kvarovi.component';
import { KvarDetailComponent } from './kvarovi/kvarovi-detail/kvar-detail.component';
import { KvarCreateComponent } from './kvarovi/kvarovi-create/kvar-create.component';
import { KvarEditComponent } from './kvarovi/kvarovi-edit/kvar-edit.component';

import { MjestaComponent } from './mjesta/mjesta.component';
import { MjestoCreateComponent } from './mjesta/mjesto-create/mjesto-create.component';
import { MjestoEditComponent } from './mjesta/mjesto-edit/mjesto-edit.component';

import { NaloziComponent } from './nalozi/nalozi.component';
import { NalogDetailComponent } from './nalozi/nalog-detail/nalog-detail.component';
import { NalogCreateComponent } from './nalozi/nalog-create/nalog-create.component';
import { NalogEditComponent } from './nalozi/nalog-edit/nalog-edit.component';

import { ForbiddenPageComponent } from './forbidden-page/forbidden-page.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import {LoginComponent} from "./login/login.component";
import {AuthGuardService} from "./guards/auth-guard.service";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
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
    path: 'radnici',
    component: RadniciComponent,
  },
  {
    path: 'radnik/detail/:id',
    component: RadnikDetailComponent,
  },
  {
    path: 'radnik/create',
    component: RadnikCreateComponent
  },
  {
    path: 'radnik/edit/:id',
    component: RadnikEditComponent,
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
    path: 'nalozi',
    component: NaloziComponent,
    canActivate: [AuthGuardService]
  },
  {
    path: 'nalog/detail/:id',
    component: NalogDetailComponent
  },
  {
    path: 'nalog/create',
    component: NalogCreateComponent
  },
  {
    path: 'nalog/edit/:id',
    component: NalogEditComponent
  },
  {
    path: 'mjesta',
    component: MjestaComponent,
  },
  {
    path: 'mjesto/create',
    component: MjestoCreateComponent,
  },
  {
    path: 'mjesto/edit/:id',
    component: MjestoEditComponent,
  },
  {
    path: 'forbidden',
    component: ForbiddenPageComponent
  },
  {
    path: 'login',
    component: LoginComponent
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
