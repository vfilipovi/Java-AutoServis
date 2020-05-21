import { Component, OnInit } from '@angular/core';
import { RadnikService } from '../radnik.service';
import { Radnik } from './../radnik.model';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-radnik-edit',
  templateUrl: './radnik-edit.component.html'
})
export class RadnikEditComponent implements OnInit {

  radnik: Radnik;

  constructor(
    private route: ActivatedRoute,
    private radnikService: RadnikService,
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
    });
  }

}
