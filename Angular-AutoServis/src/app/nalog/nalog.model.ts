import {Kvar} from "../kvar/kvar.model";
import {Klijent} from "../klijenti/klijent.model";
import {PrioritetiEnum} from "../constants/prioriteti.enum";


export class Nalog {
  id: number;
  createdAt: Date;
  updatedAt: Date;
  registracijaVozila: string;
  prioritet: PrioritetiEnum;
  datumPreuzimanja: Date;
  datumIzdavanja: Date;
  utroseniRadniSatiServisa: number;
  radnik: Radnik = new Radnik();
  klijent: Klijent = new Klijent();
  kvar: Kvar = new Kvar();

}
