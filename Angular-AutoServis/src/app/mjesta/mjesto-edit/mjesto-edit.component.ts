import { Component, OnInit } from '@angular/core';
import { MjestoService } from './../mjesto.service';
import { Mjesto } from './../mjesto.model';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-mjesto-edit',
  templateUrl: './mjesto-edit.component.html'
})
export class MjestoEditComponent implements OnInit {

  mjesto: Mjesto;

  constructor(
    private route: ActivatedRoute,
    private mejstoService: MjestoService,
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        const id = (params.get('id'));
        return this.mejstoService.getMjesto(id);
      }
      )
    ).subscribe((mjesto: Mjesto) => {
      this.mjesto = mjesto;
    });
  }

}
