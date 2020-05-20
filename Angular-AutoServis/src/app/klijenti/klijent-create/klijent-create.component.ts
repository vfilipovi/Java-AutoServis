import { Component, OnInit } from '@angular/core';
import { Klijent } from '../klijent.model';

@Component({
  selector: 'app-klijent-create',
  templateUrl: './klijent-create.component.html'
})
export class KlijentCreateComponent implements OnInit {

  klijent: Klijent;

  constructor() { }

  ngOnInit(): void {
    this.klijent = new Klijent();
  }

}
