package hr.tvz.zuti.autoservis.jobs.service;

import hr.tvz.zuti.autoservis.jobs.domain.Akcija;
import hr.tvz.zuti.autoservis.jobs.domain.OglasiVrstuMotora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AkcijaService {

    @Autowired
    private AkcijaFactory akcijaFactory;

    public String getNewAkcija(){
        Akcija akcija = akcijaFactory.getAkcija();
        return kreirajKonacnuVerzijuOglasa(akcija);
    }

    private String kreirajKonacnuVerzijuOglasa(Akcija akcija){
        akcija.postaviPopust(30);
        if (akcija instanceof OglasiVrstuMotora){
            ((OglasiVrstuMotora) akcija).oglasiVrstuMotora();
        }
        return "Današnja super akcija: " +  akcija.kreirajOglas();
    }

}
