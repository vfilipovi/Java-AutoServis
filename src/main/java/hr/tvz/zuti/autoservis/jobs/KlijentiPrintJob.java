package hr.tvz.zuti.autoservis.jobs;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Nalog;
import hr.tvz.zuti.autoservis.repositories.KlijentRepository;
import hr.tvz.zuti.autoservis.repositories.NalogRepository;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;


public class KlijentiPrintJob extends QuartzJobBean {

    private Logger log = LoggerFactory.getLogger(KlijentiPrintJob.class);

    private final KlijentRepository klijentRepository;

    public KlijentiPrintJob(KlijentRepository klijentRepository) {
        this.klijentRepository = klijentRepository;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        final Iterable<Klijent> klijenti = klijentRepository.findAll();
        List<Klijent> klijentiLista = new ArrayList<>();
        klijenti.forEach(klijentiLista::add);


        if(!klijentiLista.isEmpty()){
            log.info("++++++++++++++++++++++++++++++");
            log.info("------------------------------");
            log.info("Ovo su trenutni klijenti: ");
            log.info("------------------------------");
            klijentiLista.forEach(
                    klijent -> log.info(klijent.toString())
            );
            log.info("------------------------------");
        } else {
            log.info("Trenutno nema klijenata.");
            log.info("------------------------------");
        }

    }

}
