import { Component, OnInit, Input } from '@angular/core';
import { Klijent } from '../klijent.model';
import { ActivatedRoute } from '@angular/router';
import { KlijentService } from '../klijent.service';
import { MjestoService } from './../../mjesta/mjesto.service';
import { Mjesto } from './../../mjesta/mjesto.model';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-klijent-detail',
  templateUrl: './klijent-detail.component.html'
})
export class KlijentDetailComponent implements OnInit {

  @Input() klijent: Klijent;
  mjesto: Mjesto;

  constructor(
    private route: ActivatedRoute,
    private klijentService: KlijentService,
    private mjestoService: MjestoService
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        const id = params.get('id');
        return this.klijentService.getKlijent(id);
      }
      )
    ).subscribe((klijent: Klijent) => {
      this.klijent = klijent;
      this.mjestoService.getMjesto(klijent.mjesto.id.toString()).subscribe(
        mjesto => this.mjesto = mjesto
      );
    });
  }

}
