import { Component, OnInit } from '@angular/core';
import { Mjesto } from '../mjesto.model';

@Component({
  selector: 'app-mjesto-create',
  templateUrl: './mjesto-create.component.html'
})
export class MjestoCreateComponent implements OnInit {

  mjesto: Mjesto;

  constructor() { }

  ngOnInit(): void {
    this.mjesto = new Mjesto();
  }

}
