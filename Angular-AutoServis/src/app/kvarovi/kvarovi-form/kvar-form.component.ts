import { Component, OnInit, Input } from '@angular/core';
import { Kvar } from '../kvar.model';
import { KvarService } from '../kvar.service';
import { ToastrService } from 'ngx-toastr';
import { delay } from '../../util/delay';
import { Router } from '@angular/router';

@Component({
  selector: 'app-kvar-form',
  templateUrl: './kvar-form.component.html'
})
export class KvarFormComponent implements OnInit {

  @Input() formType: 'CREATE' | 'EDIT';

  @Input() kvar: Kvar;

  saving = false;

  constructor(
    private kvarService: KvarService,
    private toastrService: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  save() {
    this.saving = true;
    if (this.formType === 'CREATE') {
      this.createNewKvar();
    } else if (this.formType === 'EDIT')  {
      this.updateKvar();
    } else {
      throw Error('UNSUPPORTED FORM TYPE');
    }
  }

  createNewKvar() {
    this.kvarService.addKvar(this.kvar).subscribe(
      (kvar: Kvar) => {
        this.kvar = kvar;
        this.toastrService.success('Uspješno ste spremili podatke kvara!', 'Spremanje');
        delay(2000).then(() => this.router.navigate(['kvarovi']));
      },
      () => {
        this.toastrService.error('Došlo je do pogreške prilikom spremanja podataka kvara!', 'Greška');
        this.saving = false;
      }
    );
  }

  updateKvar() {
    this.kvarService.updateKvar(this.kvar).subscribe(
      (kvar: Kvar) => {
        this.kvar = kvar;
        this.toastrService.success('Uspješno ste spremili podatke kvara!', 'Spremanje');
        delay(2000).then(() => this.router.navigate(['kvarovi']));
      },
      () => {
        this.toastrService.error('Došlo je do pogreške prilikom spremanja podataka kvara!', 'Greška');
        this.saving = false;
      }
    );
  }

}
