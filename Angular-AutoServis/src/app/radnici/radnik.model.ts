import { VrstaRadnogOdnosaEnum } from '../constants/vrsta-radnog-odnosa.enum';
import { StatusRadnogOdnosaEnum } from '../constants/status-radnog-odnosa.enum';
import { Mjesto } from '../mjesta/mjesto.model';

export class Radnik {
  id: number;
  ime: string;
  prezime: string;
  oib: string;
  imeIPrezime: string;
  iznosOsnovice: number;
  koefPlace: number;
  statusRadnogOdnosa: StatusRadnogOdnosaEnum;
  vrstaRadnogOdnosa: VrstaRadnogOdnosaEnum;
  mjesto: Mjesto = new Mjesto();
}
