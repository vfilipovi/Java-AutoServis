import { Component, OnInit, Input } from '@angular/core';
import { Nalog } from '../nalog.model';
import { NalogService } from '../nalog.service';
import { ToastrService } from 'ngx-toastr';
import { delay } from '../../util/delay';
import { Router } from '@angular/router';
import {Klijent} from "../../klijenti/klijent.model";
import {Kvar} from "../../kvar/kvar.model";
import {KlijentService} from "../../klijenti/klijent.service";
import {KvarService} from "../../kvar/kvar.service";
import {PrioritetiEnum} from "../../constants/prioriteti.enum";

@Component({
  selector: 'app-nalog-form',
  templateUrl: './nalog-form.component.html'
})
export class NalogFormComponent implements OnInit {

  @Input() formType: 'CREATE' | 'EDIT';

  @Input() nalog: Nalog;

  prioritet: PrioritetiEnum;
  radnici: Radnik[];
  klijenti: Klijent[];
  kvarovi: Kvar[];

  saving = false;

  constructor(
    private nalogService: NalogService,
    private radnikService: RadnikService,
    private klijentService: KlijentService,
    private kvarService: KvarService,
    private toastrService: ToastrService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getKlijenti();
    this.getKvarovi()
    this.getRadnici()
  }

  save() {
    this.saving = true;
    if (this.formType === 'CREATE') {
      this.createNewNalog();
    } else if (this.formType === 'EDIT')  {
      this.updateNalog();
    } else {
      throw Error('UNSUPPORTED FORM TYPE');
    }
  }

  createNewNalog() {
    this.nalogService.addNalog(this.nalog).subscribe(
      (nalog: Nalog) => {
        this.nalog = nalog;
        this.toastrService.success('Uspješno ste spremili podatke naloga!', 'Spremanje');
        delay(2000).then(() => this.router.navigate(['nalozi']));
      },
      () => {
        this.toastrService.error('Došlo je do pogreške prilikom spremanja podataka naloga!', 'Greška');
        this.saving = false;
      }
    );
  }

  updateNalog() {
    this.nalogService.updateNalog(this.nalog).subscribe(
      (nalog: Nalog) => {
        this.nalog = nalog;
        this.toastrService.success('Uspješno ste spremili podatke naloga!', 'Spremanje');
        delay(2000).then(() => this.router.navigate(['nalozi']));
      },
      () => {
        this.toastrService.error('Došlo je do pogreške prilikom spremanja podataka naloga!', 'Greška');
        this.saving = false;
      }
    );
  }

  getRadnici(): void {
    this.radnikService.getRadnici()
      .subscribe(radnici => this.radnici = radnici);
  }

  getKlijenti(): void {
    this.klijentService.getKlijenti()
      .subscribe(klijenti => this.klijenti = klijenti);
  }

  getKvarovi(): void {
    this.kvarService.getKvarovi()
      .subscribe(kvarovi => this.kvarovi = kvarovi);
  }

}
