package hr.tvz.zuti.autoservis.jobs;

import hr.tvz.zuti.autoservis.domain.Klijent;
import hr.tvz.zuti.autoservis.domain.Kvar;
import hr.tvz.zuti.autoservis.repositories.KlijentRepository;
import hr.tvz.zuti.autoservis.repositories.KvarRepository;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;


public class KvarPrintJob extends QuartzJobBean {

    private Logger log = LoggerFactory.getLogger(KvarPrintJob.class);

    private final KvarRepository kvarRepository;

    public KvarPrintJob(KvarRepository kvarRepository) {
        this.kvarRepository = kvarRepository;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        final Iterable<Kvar> kvarovi = kvarRepository.findAll();
        List<Kvar> kvaroviLista = new ArrayList<>();
        kvarovi.forEach(kvaroviLista::add);


        if(!kvaroviLista.isEmpty()){
            log.info("++++++++++++++++++++++++++++++");
            log.info("------------------------------");
            log.info("Ovo su trenutni kvarovi: ");
            log.info("------------------------------");
            kvaroviLista.forEach(
                    klijent -> log.info(klijent.toString())
            );
            log.info("------------------------------");
        } else {
            log.info("Trenutno nema kavrova.");
            log.info("------------------------------");
        }

    }

}
