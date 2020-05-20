import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS, HttpClient } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastrModule } from 'ngx-toastr';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';

import { AppComponent } from './app.component';

import { KlijentiComponent } from './klijenti/klijenti.component';
import { KlijentFormComponent } from './klijenti/klijent-form/klijent-form.component';
import { KlijentDetailComponent } from './klijenti/klijent-detail/klijent-detail.component';
import { KlijentEditComponent } from './klijenti/klijent-edit/klijent-edit.component';
import { KlijentCreateComponent } from './klijenti/klijent-create/klijent-create.component';

import { MjestaComponent } from './mjesta/mjesta.component';
import {KvaroviComponent} from "./kvar/kvarovi.component";
import {KvarCreateComponent} from "./kvar/kvarovi-create/kvar-create.component";
import {KvarDetailComponent} from "./kvar/kvarovi-detail/kvar-detail.component";
import {KvarEditComponent} from "./kvar/kvarovi-edit/kvar-edit.component";
import {KvarFormComponent} from "./kvar/kvarovi-form/kvar-form.component";
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";

import { RadniciComponent } from "./radnik/radnici.component";
import {RadnikCreateComponent} from "./radnik/radnik-create/radnik-create.component";

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    KlijentiComponent,
    KlijentFormComponent,
    KlijentCreateComponent,
    KlijentEditComponent,
    KlijentDetailComponent,
    MjestaComponent,
    KvaroviComponent,
    KvarCreateComponent,
    KvarDetailComponent,
    KvarEditComponent,
    KvarFormComponent,
    RadniciComponent,
    RadnikCreateComponent

  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    ToastrModule.forRoot({
      timeOut: 3000,
      positionClass: 'toast-bottom-right',
      preventDuplicates: true,
    }),
    TranslateModule.forRoot(
      {
        loader: {
          provide: TranslateLoader,
          useFactory: HttpLoaderFactory,
          deps: [HttpClient]
        },
        defaultLanguage: 'hr'
      }
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
