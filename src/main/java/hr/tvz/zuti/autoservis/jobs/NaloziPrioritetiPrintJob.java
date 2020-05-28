package hr.tvz.zuti.autoservis.jobs;

import hr.tvz.zuti.autoservis.domain.Nalog;
import hr.tvz.zuti.autoservis.repositories.NalogRepository;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;


public class NaloziPrioritetiPrintJob extends QuartzJobBean {

    private Logger log = LoggerFactory.getLogger(NaloziPrioritetiPrintJob.class);

    private final NalogRepository nalogRepository;

    public NaloziPrioritetiPrintJob(NalogRepository nalogRepository) {
        this.nalogRepository = nalogRepository;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        final Iterable<Nalog> nalozi = nalogRepository.findAll();
        List<Nalog> naloziLista = new ArrayList<>();
        nalozi.forEach(naloziLista::add);


        if(!naloziLista.isEmpty()){
            int niski = 0;
            int srednji = 0;
            int visoki = 0;
            log.info("++++++++++++++++++++++++++++++");
            log.info("------------------------------");
            log.info("Ovo su trenutni nalozi");
            log.info("------------------------------");
            naloziLista.forEach(
                    nalog -> log.info(nalog.toString())
            );
            log.info("------------------------------");
            for (Nalog nalog: naloziLista) {
                if(nalog.getPrioritet().toString().toUpperCase().equals("NISKI")) niski++;
                else if(nalog.getPrioritet().toString().toUpperCase().equals("SREDNJI")) srednji++;
                else visoki++;
            }
            log.info("Broj naloga po prioritetima: ");
            log.info("NISKI: " + niski);
            log.info("SREDNJI: " + srednji);
            log.info("VISOKI: " + visoki);
            log.info("------------------------------");
        } else {
            log.info("Trenutno nema naloga.");
            log.info("------------------------------");
        }

    }

}
