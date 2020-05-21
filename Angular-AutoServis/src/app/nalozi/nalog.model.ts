import { PrioritetEnum } from '../constants/prioritet.enum';
import { Klijent } from '../klijenti/klijent.model';
import { Radnik } from '../radnici/radnik.model';
import { Kvar } from '../kvarovi/kvar.model';


export class Nalog {
  id: number;
  createdAt: Date;
  updatedAt: Date;
  registracijaVozila: string;
  prioritet: PrioritetEnum;
  datumPreuzimanja: Date;
  datumIzdavanja: Date;
  utroseniRadniSatiServisa: number;
  radnik: Radnik = new Radnik();
  klijent: Klijent = new Klijent();
  kvar: Kvar = new Kvar();
}
