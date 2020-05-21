import { Component, OnInit, Input } from '@angular/core';
import { Nalog } from '../nalog.model';
import { ActivatedRoute } from '@angular/router';
import { NalogService } from '../nalog.service';
import { switchMap } from 'rxjs/operators';

import { Klijent } from '../../klijenti/klijent.model';
import { KlijentService } from '../../klijenti/klijent.service';

import { Radnik } from './../../radnici/radnik.model';
import { RadnikService } from './../../radnici/radnik.service';

import { Kvar } from '../../kvarovi/kvar.model';
import { KvarService } from '../../kvarovi/kvar.service';

@Component({
  selector: 'app-nalog-detail',
  templateUrl: './nalog-detail.component.html',
})
export class NalogDetailComponent implements OnInit {
  @Input() nalog: Nalog;
  klijent: Klijent;
  radnik: Radnik;
  kvar: Kvar;

  id: number;

  constructor(
    private route: ActivatedRoute,
    private nalogService: NalogService,
    private klijentService: KlijentService,
    private radnikService: RadnikService,
    private kvarService: KvarService
  ) {}

  ngOnInit(): void {
    this.route.paramMap
      .pipe(
        switchMap((params) => {
          const id = params.get('id');
          return this.nalogService.getNalog(id.toString());
        })
      )
      .subscribe((nalog: Nalog) => {
        this.nalog = nalog;
        this.radnikService
          .getRadnik(nalog.radnik.id.toString())
          .subscribe((radnik) => (this.radnik = radnik));
        this.klijentService
          .getKlijent(nalog.klijent.id.toString())
          .subscribe((klijent) => (this.klijent = klijent));
        this.kvarService
          .getKvar(nalog.kvar.id.toString())
          .subscribe((kvar) => (this.kvar = kvar));
      });
  }
}
