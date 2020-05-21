import { Component, OnInit, Input } from '@angular/core';
import { Radnik } from '../radnik.model';
import { VrstaRadnogOdnosaEnum } from './../../constants/vrsta-radnog-odnosa.enum';
import { StatusRadnogOdnosaEnum } from './../../constants/status-radnog-odnosa.enum';
import { RadnikService } from '../radnik.service';
import { MjestoService } from './../../mjesta/mjesto.service';
import { Mjesto } from './../../mjesta/mjesto.model';
import { ToastrService } from 'ngx-toastr';
import { delay } from '../../util/delay';
import { Router } from '@angular/router';

@Component({
  selector: 'app-radnik-form',
  templateUrl: './radnik-form.component.html'
})
export class RadnikFormComponent implements OnInit {

  @Input() formType: 'CREATE' | 'EDIT';

  @Input() radnik: Radnik;

  mjesta: Mjesto[];
  statusRadnogOdnosa: StatusRadnogOdnosaEnum;
  vrstaRadnogOdnosa: VrstaRadnogOdnosaEnum;

  saving = false;

  constructor(
    private radnikService: RadnikService,
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
      this.createNewRadnik();
    } else if (this.formType === 'EDIT')  {
      this.updateRadnik();
    } else {
      throw Error('UNSUPPORTED FORM TYPE');
    }
  }

  createNewRadnik() {
    this.radnikService.addRadnik(this.radnik).subscribe(
      (radnik: Radnik) => {
        this.radnik = radnik;
        this.toastrService.success('Uspješno ste spremili podatke radnika!', 'Spremanje');
        delay(2000).then(() => this.router.navigate(['radnici']));
      },
      () => {
        this.toastrService.error('Došlo je do pogreške prilikom spremanja podataka radnika!', 'Greška');
        this.saving = false;
      }
    );
  }

  updateRadnik() {
    this.radnikService.updateRadnik(this.radnik).subscribe(
      (radnik: Radnik) => {
        this.radnik = radnik;
        this.toastrService.success('Uspješno ste spremili podatke radnika!', 'Aržurirano');
        delay(2000).then(() => this.router.navigate(['radnici']));
      },
      () => {
        this.toastrService.error('Došlo je do pogreške prilikom spremanja podataka radnika!');
        this.saving = false;
      }
    );
  }

  getMjesta(): void {
    this.mjestoService.getMjesta()
      .subscribe(mjesta => this.mjesta = mjesta);
  }
}
