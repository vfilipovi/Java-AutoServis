package hr.tvz.zuti.autoservis.akcije.service;

import hr.tvz.zuti.autoservis.akcije.domain.Akcija;
import hr.tvz.zuti.autoservis.akcije.domain.Farbanje;
import hr.tvz.zuti.autoservis.akcije.domain.ServisBenzMotora;
import hr.tvz.zuti.autoservis.akcije.domain.ServisDizelMotora;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Component
public class AkcijaFactory {
    private static Akcija akcija = null;

    public Akcija getAkcija(){
        if(akcija == null) {
            Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Europe/Zagreb"));
            Date date = c.getTime();
            c.setTime(date);
            int danUTjednu = c.get(Calendar.DAY_OF_WEEK);
            if (danUTjednu != 1){
                danUTjednu -= 1;
            }
            else {
                danUTjednu = 7;
            }

            if ((danUTjednu >= 1) && (danUTjednu <= 3)) {
                akcija = new ServisBenzMotora();
            } else if ((danUTjednu >= 4) && (danUTjednu <= 5)) {
                akcija = new ServisDizelMotora();
            } else {
                akcija = new Farbanje();
            }
        }
        return akcija;
    }

    @Scheduled(cron="0 0 0 * * ?")
    private void onSchedule() {
        akcija = null;
        System.out.println("ponoc");
    }

}
