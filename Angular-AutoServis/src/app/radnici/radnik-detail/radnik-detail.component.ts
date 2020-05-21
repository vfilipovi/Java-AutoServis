import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Radnik } from '../radnik.model';
import { RadnikService } from '../radnik.service';
import { MjestoService } from './../../mjesta/mjesto.service';
import { Mjesto } from './../../mjesta/mjesto.model';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-radnik-detail',
  templateUrl: './radnik-detail.component.html'
})
export class RadnikDetailComponent implements OnInit {

  @Input() radnik: Radnik;

  mjesto: Mjesto;

  constructor(
    private route: ActivatedRoute,
    private radnikService: RadnikService,
    private mjestoService: MjestoService
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        const id = params.get('id');
        return this.radnikService.getRadnik(id);
      }
      )
    ).subscribe((radnik: Radnik) => {
      this.radnik = radnik;
      this.mjestoService.getMjesto(radnik.mjesto.id.toString()).subscribe(
        mjesto => this.mjesto = mjesto
      );
    });
  }

}
