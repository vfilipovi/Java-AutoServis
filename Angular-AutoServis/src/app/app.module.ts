import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
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

import { RadniciComponent } from './radnici/radnici.component';
import { RadnikFormComponent } from './radnici/radnik-form/radnik-form.component';
import { RadnikEditComponent } from './radnici/radnik-edit/radnik-edit.component';
import { RadnikDetailComponent } from './radnici/radnik-detail/radnik-detail.component';
import { RadnikCreateComponent } from './radnici/radnik-create/radnik-create.component';

import { MjestaComponent } from './mjesta/mjesta.component';
import { MjestoCreateComponent } from './mjesta/mjesto-create/mjesto-create.component';
import { MjestoEditComponent } from './mjesta/mjesto-edit/mjesto-edit.component';
import { MjestoFormComponent } from './mjesta/mjesto-form/mjesto-form.component';

import { KvaroviComponent } from './kvarovi/kvarovi.component';
import { KvarCreateComponent } from './kvarovi/kvarovi-create/kvar-create.component';
import { KvarDetailComponent } from './kvarovi/kvarovi-detail/kvar-detail.component';
import { KvarEditComponent } from './kvarovi/kvarovi-edit/kvar-edit.component';
import { KvarFormComponent } from './kvarovi/kvarovi-form/kvar-form.component';

import { NaloziComponent } from './nalozi/nalozi.component';
import { NalogDetailComponent } from './nalozi/nalog-detail/nalog-detail.component';
import { NalogCreateComponent } from './nalozi/nalog-create/nalog-create.component';
import { NalogEditComponent } from './nalozi/nalog-edit/nalog-edit.component';
import { NalogFormComponent } from './nalozi/nalog-form/nalog-form.component';

import { PageNotFoundComponent} from './page-not-found/page-not-found.component';

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
    RadniciComponent,
    RadnikFormComponent,
    RadnikDetailComponent,
    RadnikCreateComponent,
    RadnikEditComponent,
    MjestaComponent,
    MjestoCreateComponent,
    MjestoEditComponent,
    MjestoFormComponent,
    KvaroviComponent,
    KvarCreateComponent,
    KvarDetailComponent,
    KvarEditComponent,
    KvarFormComponent,
    NaloziComponent,
    NalogDetailComponent,
    NalogCreateComponent,
    NalogEditComponent,
    NalogFormComponent
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
export class AppModule {}
