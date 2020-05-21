import { Component, OnInit, Input } from '@angular/core';
import { Mjesto } from './../mjesto.model';
import { MjestoService } from './../mjesto.service';
import { ToastrService } from 'ngx-toastr';
import { delay } from '../../util/delay';
import { Router } from '@angular/router';

@Component({
  selector: 'app-mjesto-form',
  templateUrl: './mjesto-form.component.html'
})
export class MjestoFormComponent implements OnInit {

  @Input() formType: 'CREATE' | 'EDIT';

  @Input() mjesto: Mjesto;

  saving = false;

  constructor(
    private mjestoService: MjestoService,
    private toastrService: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  save() {
    this.saving = true;
    if (this.formType === 'CREATE') {
      this.createNewMjesto();
    } else if (this.formType === 'EDIT')  {
      this.updateMjesto();
    } else {
      throw Error('UNSUPPORTED FORM TYPE');
    }
  }

  createNewMjesto() {
    this.mjestoService.addMjesto(this.mjesto).subscribe(
      (mjesto: Mjesto) => {
        this.mjesto = mjesto;
        this.toastrService.success('Uspješno ste spremili podatke mjesta!', 'Spremanje');
        delay(2000).then(() => this.router.navigate(['mjesta']));
      },
      () => {
        this.toastrService.error('Došlo je do pogreške prilikom spremanja podataka mjesta!', 'Greška');
        this.saving = false;
      }
    );
  }

  updateMjesto() {
    this.mjestoService.updateMjesto(this.mjesto).subscribe(
      (mjesto: Mjesto) => {
        this.mjesto = mjesto;
        this.toastrService.success('Uspješno ste spremili podatke mjesta!', 'Spremanje');
        delay(2000).then(() => this.router.navigate(['mjesta']));
      },
      () => {
        this.toastrService.error('Došlo je do pogreške prilikom spremanja podataka mjesta!', 'Greška');
        this.saving = false;
      }
    );
  }

}
