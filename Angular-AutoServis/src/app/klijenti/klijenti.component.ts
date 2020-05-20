import { Component, OnInit } from '@angular/core';
import { Klijent } from './klijent.model';
import { KlijentService} from './klijent.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
// import { UserService } from '../user/user.service';

@Component({
  selector: 'app-klijenti',
  templateUrl: './klijenti.component.html'
})
export class KlijentiComponent implements OnInit {

  klijenti: Klijent[];

  constructor(
    private klijentService: KlijentService,
    private router: Router,
    private toastrService: ToastrService,
    // public userService: UserService
    ) { }

  ngOnInit(): void {
    this.getKlijenti();
  }

  getKlijenti(): void {
    this.klijentService.getKlijenti()
      .subscribe(klijenti => this.klijenti = klijenti);
  }

  navigateToEdit(klijent: Klijent) {
    this.router.navigate([`/klijenti/edit/${klijent.id}`]);
  }

  navigateToDetails(klijent: Klijent) {
    this.router.navigate([`/klijent/detail/${klijent.id}`]);
  }

  deleteKlijent(klijent: Klijent) {
    this.klijenti = this.klijenti.filter(s => s !== klijent);
    this.klijentService.deleteKlijent(klijent).subscribe(
      () => this.toastrService.success('Uspješno ste obrisali klijenta!'),
      () => this.toastrService.success('Došlo je do pogreške prilikom brisanja klijenta!')
    );
  }

}
