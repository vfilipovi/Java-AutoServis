import { Component, OnInit } from '@angular/core';
import { Nalog } from '../nalog.model';


@Component({
  selector: 'app-nalog-create',                 //FIX
  templateUrl: './nalog-create.component.html'
})
export class NalogCreateComponent implements OnInit {

  nalog: Nalog;

  constructor() { }

  ngOnInit(): void {
    this.nalog = new Nalog();
  }

}
