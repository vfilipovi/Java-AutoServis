import { Component, OnInit } from '@angular/core';
import { Nalog } from './nalog.model';
import { NalogService} from './nalog.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-nalozi',                     //popravi
  templateUrl: './nalozi.component.html'
})
export class NaloziComponent implements OnInit {

  nalozi: Nalog[];

  constructor(
    private nalogService: NalogService,
    private router: Router,
    private toastrService: ToastrService,
    //public userService: UserService
  ) { }

  ngOnInit(): void {
    this.getNalozi();
  }

  getNalozi(): void {
    this.nalogService.getNalozi()
      .subscribe(nalozi => this.nalozi = nalozi);
  }

  navigateToEdit(nalog: Nalog) {
    this.router.navigate([`/nalog/edit/${nalog.id}`]);
  }

  navigateToDetails(nalog: Nalog) {
    this.router.navigate([`/nalog/detail/${nalog.id}`]);
  }

}
