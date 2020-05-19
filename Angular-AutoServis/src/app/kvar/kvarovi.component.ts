import { Component, OnInit } from '@angular/core';
import { Kvar } from './kvar.model';
import { KvarService} from './kvar.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-students',                     //popravi
  templateUrl: './kvarovi.component.html'
})
export class KvaroviComponent implements OnInit {

  kvarovi: Kvar[];

  constructor(
    private kvarService: KvarService,
    private router: Router,
    private toastrService: ToastrService,
    public userService: UserService
    ) { }

  ngOnInit(): void {
    this.getKvarovi();
  }

  getKvarovi(): void {
    this.kvarService.getKvarovi()
      .subscribe(kvarovi => this.kvarovi = kvarovi);
  }

  navigateToEdit(kvar: Kvar) {
    this.router.navigate([`/kvarovi/edit/${kvar.id}`]);
  }

  navigateToDetails(kvar: Kvar) {
    this.router.navigate([`/kvarovi/detail/${kvar.id}`]);
  }

}
