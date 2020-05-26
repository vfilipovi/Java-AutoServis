import { Component, OnInit } from '@angular/core';
import { Kvar } from './kvar.model';
import { KvarService} from './kvar.service';
import { Router } from '@angular/router';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-kvarovi',
  templateUrl: './kvarovi.component.html'
})
export class KvaroviComponent implements OnInit {

  kvarovi: Kvar[];

  constructor(
    private kvarService: KvarService,
    private router: Router,
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
    this.router.navigate([`/kvar/edit/${kvar.id}`]);
  }

  navigateToDetails(kvar: Kvar) {
    this.router.navigate([`/kvar/detail/${kvar.id}`]);
  }

}
