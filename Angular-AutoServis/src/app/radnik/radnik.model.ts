import { Mjesto } from '../mjesta/mjesto.model';

export class Radnik {
  id: number;
  ime: string;
  prezime: string;
  oib: string;
  imeIPrezime: string;
  iznosOsnovice: number;
  koefPlace: number;
  statusRadnogOdnosa: string;
  vrstaRadnogOdnosa: string;
  mjesto: Mjesto = new Mjesto();

}
