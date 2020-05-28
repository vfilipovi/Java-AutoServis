package hr.tvz.zuti.autoservis.jobs;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Nalog;
import hr.tvz.zuti.autoservis.domain.Radnik;
import hr.tvz.zuti.autoservis.repositories.KlijentRepository;
import hr.tvz.zuti.autoservis.repositories.RadnikRepository;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;


public class RadniciPrintJob extends QuartzJobBean {

    private Logger log = LoggerFactory.getLogger(RadniciPrintJob.class);

    private final RadnikRepository radnikRepository;

    public RadniciPrintJob(RadnikRepository radnikRepository) {
        this.radnikRepository = radnikRepository;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        final Iterable<Radnik> radnici = radnikRepository.findAll();
        List<Radnik> radniciLista = new ArrayList<>();
        radnici.forEach(radniciLista::add);


        if(!radniciLista.isEmpty()){
            int odredeno = 0;
            int neodredeno = 0;
            int prektikant = 0;
            log.info("++++++++++++++++++++++++++++++");
            log.info("------------------------------");
            log.info("Ovo su trenutni radnici: ");
            log.info("------------------------------");
            radniciLista.forEach(
                    klijent -> log.info(klijent.toString())
            );
            log.info("------------------------------");
            for (Radnik radnik: radniciLista) {
                if(radnik.getVrstaRadnogOdnosa().toString().toUpperCase().equals("ODREDENO")) odredeno++;
                else if(radnik.getVrstaRadnogOdnosa().toString().toUpperCase().equals("NEODREDENO")) neodredeno++;
                else prektikant++;
            }
            log.info("Broj radnika po vrsti radno odnosa: ");
            log.info("ODREDENO: " + odredeno);
            log.info("NEODREDENO: " + neodredeno);
            log.info("PRAKTIKANT: " + prektikant);
            log.info("------------------------------");
        } else {
            log.info("Trenutno nema radnika.");
            log.info("------------------------------");
        }

    }

}
