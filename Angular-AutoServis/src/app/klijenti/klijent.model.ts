import { Mjesto } from '../mjesta/mjesto.model';

export class Klijent {
  id: number;
  ime: string;
  prezime: string;
  oib: string;
  imeIPrezime: string;
  brojMob: string;
  email: string;
  mjesto: Mjesto = new Mjesto();
}
