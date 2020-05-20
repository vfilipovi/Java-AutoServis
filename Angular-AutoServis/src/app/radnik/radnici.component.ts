import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import {Radnik} from "./radnik.model";
import {RadnikService} from "./radnik.service";
import {Klijent} from "../klijenti/klijent.model";

@Component({
  selector: 'app/radnici',
  templateUrl: '../radnici.component.html'
})

export class RadniciComponent implements OnInit{
  radnici: Radnik[];

  constructor(
    private radnikService: RadnikService;
    private router: Router;
    private toastrService: ToastrService;
  ) { }

  ngOnInit(): void{
    this.getRadnici();
}
getRadnici(): void {
  this.radnikService.getRadnici()
    .subscribe(radnici => this.radnici = radnici);
}

navigateToEdit(radnici: Radnik) {
  this.router.navigate([`/radnik/edit/${radnik.id}`]);
}

navigateToDetails(radnik: Radnik) {
  this.router.navigate([`/radnik/detail/${radnik.id}`]);
}

deleteRadnik(radnik: Radnik) {
  if (confirm('Jese li sigurrni da želite obrisati radnika "' + radnik.imeIPrezime + '" ?')) {
    this.radnici = this.radnici.filter(s => s !== radnik);
    this.radnikService.deleteRadnik(radnik).subscribe(
      () => this.toastrService.success('Zahtjev za brisanjem je izvršen!', 'Brisanje'),
      () => this.toastrService.error('Došlo je do pogreške zahtjeva za brisanje.', 'Greška')
    );
  }
}

}
