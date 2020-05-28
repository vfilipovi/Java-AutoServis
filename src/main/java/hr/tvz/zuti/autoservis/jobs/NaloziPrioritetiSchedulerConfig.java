package hr.tvz.zuti.autoservis.jobs;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NaloziPrioritetiSchedulerConfig {

    private static final String NALOZI_PRIORITETI_PRINT_JOB_IDENTITY = "naloziPrioritetiPrintJob";
    private static final String NALOZI_PRIORITETI_PRINT_TRIGGER = "naloziPrioritetiPrintTrigger";

    @Bean
    public JobDetail naloziPrioritetiPrintJobDetail() {
        return JobBuilder.newJob(NaloziPrioritetiPrintJob.class).withIdentity(NALOZI_PRIORITETI_PRINT_JOB_IDENTITY)
                .storeDurably().build();
    }

    @Bean
    public SimpleTrigger naloziPrioritetiPrintTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5).repeatForever();

        return TriggerBuilder.newTrigger().forJob(naloziPrioritetiPrintJobDetail())
                .withIdentity(NALOZI_PRIORITETI_PRINT_TRIGGER).withSchedule(scheduleBuilder).build();
    }

}
