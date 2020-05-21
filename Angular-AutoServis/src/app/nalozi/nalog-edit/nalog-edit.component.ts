import { Component, OnInit } from '@angular/core';
import { NalogService } from '../nalog.service';
import { Nalog } from '../nalog.model';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-nalog-edit',
  templateUrl: './nalog-edit.component.html'
})
export class NalogEditComponent implements OnInit {

  nalog: Nalog;

  constructor(
    private route: ActivatedRoute,
    private nalogService: NalogService,
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        const id = (params.get('id'));
        return this.nalogService.getNalog(id);
      }
      )
    ).subscribe((nalog: Nalog) => {
      this.nalog = nalog;
    });
  }

}
