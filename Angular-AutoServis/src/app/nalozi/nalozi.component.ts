import { Component, OnInit } from '@angular/core';
import { Nalog } from './nalog.model';
import { NalogService} from './nalog.service';
import { AkcijaService } from '../akcija/akcija.service';
import { Akcija } from '../akcija/akcija.model';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-nalozi',
  templateUrl: './nalozi.component.html'
})
export class NaloziComponent implements OnInit {

  nalozi: Nalog[];
  akcija: Akcija;

  constructor(
    private nalogService: NalogService,
    private akcijaService: AkcijaService,
    private router: Router,
    private toastrService: ToastrService,
    public userService: UserService
  ) { }

  ngOnInit(): void {
    this.getNalozi();
    this.getAkcija();
  }

  getNalozi(): void {
    this.nalogService.getNalozi()
      .subscribe(nalozi => this.nalozi = nalozi);
  }

  getAkcija(): void {
    this.akcijaService.getAkcija()
      .subscribe(akcija => this.akcija = akcija);
  }

  navigateToEdit(nalog: Nalog) {
    this.router.navigate([`/nalog/edit/${nalog.id}`]);
  }

  navigateToDetails(nalog: Nalog) {
    this.router.navigate([`/nalog/detail/${nalog.id}`]);
  }

}
