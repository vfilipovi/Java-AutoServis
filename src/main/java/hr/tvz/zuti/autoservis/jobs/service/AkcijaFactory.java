package hr.tvz.zuti.autoservis.jobs.service;

import hr.tvz.zuti.autoservis.jobs.domain.Akcija;
import hr.tvz.zuti.autoservis.jobs.domain.Farbanje;
import hr.tvz.zuti.autoservis.jobs.domain.ServisBenzMotora;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class AkcijaFactory {
    private static Akcija akcija = null;

    public Akcija getAkcija(){
        if(akcija == null) {
            Calendar c = Calendar.getInstance();
            Date date = c.getTime();
            c.setTime(date);
            int danuTjednu = c.get(Calendar.DAY_OF_WEEK);

            if ((danuTjednu >= 1) && (danuTjednu <= 3)) {
                akcija = new ServisBenzMotora();
            } else if ((danuTjednu >= 4) && (danuTjednu <= 5)) {
                akcija = new ServisBenzMotora();
            } else {
                akcija = new Farbanje();
            }
        }
        return akcija;
    }




}
