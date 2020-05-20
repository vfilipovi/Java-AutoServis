import { Component, Directive, OnInit } from '@angular/core';
import { KlijentService } from '../klijent.service';
import { Klijent } from '../klijent.model';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-klijent-edit',
  templateUrl: './klijent-edit.component.html'
})
export class KlijentEditComponent implements OnInit {

  klijent: Klijent;

  constructor(
    private route: ActivatedRoute,
    private klijentService: KlijentService,
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
    });
  }

}
