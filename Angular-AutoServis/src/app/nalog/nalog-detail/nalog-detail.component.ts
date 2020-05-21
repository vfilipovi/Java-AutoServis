import { Component, OnInit, Input } from '@angular/core';
import { Nalog } from '../nalog.model';
import { ActivatedRoute } from '@angular/router';
import { NalogService } from '../nalog.service';
import { switchMap } from 'rxjs/operators';
import {Klijent} from "../../klijenti/klijent.model";
import {Kvar} from "../../kvar/kvar.model";
import {KvarService} from "../../kvar/kvar.service";
import {KlijentService} from "../../klijenti/klijent.service";

@Component({
  selector: 'app-Nalog-detail',
  templateUrl: './Nalog-detail.component.html'
})
export class NalogDetailComponent implements OnInit {

  @Input() nalog: Nalog;
  radnik: Radnik;
  klijent: Klijent;
  kvar: Kvar;

  id: number;

  constructor(
    private route: ActivatedRoute,
    private nalogService: NalogService,
    private rednikService: RadnikService,
    private klijentService: KlijentService,
    private kvarService: KvarService
  ) { }


  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        const id = params.get('id');
        return this.nalogService.getNalog(id.toString());
      }
      )
    ).subscribe((nalog: Nalog) => {
      this.nalog = nalog;
      this.radnikService.getRadnik(nalog.radnik.id.toString()).subscribe(
        radnik => this.radnik = radnik
      );
      this.klijentService.getKlijent(nalog.klijent.id.toString()).subscribe(
        klijent => this.klijent = klijent
      );
      this.kvarService.getKvar(nalog.kvar.id.toString()).subscribe(
        kvar => this.radnik = kvar
      );
    });
  }


}
