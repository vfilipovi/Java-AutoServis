import { Component, OnInit, Input } from '@angular/core';
import { Klijent } from '../klijent.model';
import { KlijentService } from '../klijent.service';
import { MjestoService } from './../../mjesta/mjesto.service';
import { Mjesto } from './../../mjesta/mjesto.model';
import { ToastrService } from 'ngx-toastr';
import { delay } from '../../util/delay';
import { Router } from '@angular/router';

@Component({
  selector: 'app-klijent-form',
  templateUrl: './klijent-form.component.html'
})
export class KlijentFormComponent implements OnInit {

  @Input() formType: 'CREATE' | 'EDIT';

  @Input() klijent: Klijent;

  mjesta: Mjesto[];

  saving = false;

  constructor(
    private klijentService: KlijentService,
    private mjestoService: MjestoService,
    private toastrService: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getMjesta();
  }

  save() {
    this.saving = true;
    if (this.formType === 'CREATE') {
      this.createNewKlijent();
    } else if (this.formType === 'EDIT')  {
      this.updateKlijent();
    } else {
      throw Error('UNSUPPORTED FORM TYPE');
    }
  }

  createNewKlijent() {
    this.klijentService.addKlijent(this.klijent).subscribe(
      (klijent: Klijent) => {
        this.klijent = klijent;
        this.toastrService.success('Uspješno ste spremili podatke klijenta!');
        delay(2000).then(() => this.router.navigate(['klijenti']));
      },
      () => {
        this.toastrService.error('Došlo je do pogreške prilikom spremanja podataka klijenta!');
        this.saving = false;
      }
    );
  }

  updateKlijent() {
    this.klijentService.updateKlijent(this.klijent).subscribe(
      (klijent: Klijent) => {
        this.klijent = klijent;
        console.log(klijent);

        this.toastrService.success('Uspješno ste spremili podatke klijenta!');
        delay(2000).then(() => this.router.navigate(['klijenti']));
      },
      () => {
        this.toastrService.error('Došlo je do pogreške prilikom spremanja podataka klijenta!');
        this.saving = false;
      }
    );
  }

  getMjesta(): void {
    this.mjestoService.getMjesta()
      .subscribe(mjesta => this.mjesta = mjesta);
  }
}
