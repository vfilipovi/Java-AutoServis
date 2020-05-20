import { Component, OnInit } from '@angular/core';
import { Mjesto } from './mjesto.model';
import { MjestoService} from './mjesto.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
// import { UserService } from '../user/user.service';

@Component({
  selector: 'app-mjesta',
  templateUrl: './mjesta.component.html'
})
export class MjestaComponent implements OnInit {

  mjesta: Mjesto[];

  constructor(
    private mjestoService: MjestoService,
    private router: Router,
    private toastrService: ToastrService,
    // public userService: UserService
    ) { }

  ngOnInit(): void {
    this.getMjesta();
  }

  getMjesta(): void {
    this.mjestoService.getMjesta()
      .subscribe(mjesta => this.mjesta = mjesta);
  }

  navigateToEdit(mjesto: Mjesto) {
    this.router.navigate([`/mjesto/edit/${mjesto.id}`]);
  }

  navigateToDetails(mjesto: Mjesto) {
    this.router.navigate([`/mjesto/detail/${mjesto.id}`]);
  }

  deleteMjesto(mjesto: Mjesto) {
    if (confirm()) {

    }
    this.mjesta = this.mjesta.filter(s => s !== mjesto);
    this.mjestoService.deleteMjesto(mjesto).subscribe(
      () => this.toastrService.success('Jese li sigurrni da želite obrisati mjesto: ' + mjesto.nazivMjesta, 'Brisanje'),
      () => this.toastrService.error('Došlo je do pogreške prilikom brisanja mjesta!', 'Greška')
    );
  }

}
