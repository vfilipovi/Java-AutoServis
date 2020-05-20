import { Component, OnInit } from '@angular/core';
import { Radnik } from '../klijent.model';

@Component({
  selector: 'app-radnik-create',
  templateUrl: './radnik-create.component.html'
})
export class RadnikCreateComponent implements OnInit {

  radnik: Radnik;

  constructor() { }

  ngOnInit(): void {
    this.radnik = new Radnik();
  }

}
