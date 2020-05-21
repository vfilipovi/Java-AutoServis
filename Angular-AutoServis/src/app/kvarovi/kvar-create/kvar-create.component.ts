import { Component, OnInit } from '@angular/core';
import { Kvar } from '../kvar.model';

@Component({
  selector: 'app-kvar-create',                 //FIX
  templateUrl: './kvar-create.component.html'
})
export class KvarCreateComponent implements OnInit {

  kvar: Kvar;

  constructor() { }

  ngOnInit(): void {
    this.kvar = new Kvar();
  }

}
