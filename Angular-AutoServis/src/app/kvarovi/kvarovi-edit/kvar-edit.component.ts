import { Component, OnInit } from '@angular/core';
import { KvarService } from '../kvar.service';
import { Kvar } from '../kvar.model';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-kvar-edit',
  templateUrl: './kvar-edit.component.html'
})
export class KvarEditComponent implements OnInit {

  kvar: Kvar;

  constructor(
    private route: ActivatedRoute,
    private kvarService: KvarService,
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        const id = (params.get('id'));
        return this.kvarService.getKvar(id);
      }
      )
    ).subscribe((kvar: Kvar) => {
      this.kvar = kvar;
    });
  }

}
