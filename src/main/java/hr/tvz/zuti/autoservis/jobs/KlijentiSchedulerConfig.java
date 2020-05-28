package hr.tvz.zuti.autoservis.jobs;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KlijentiSchedulerConfig {

    private static final String KLIJENTI_PRINT_JOB_IDENTITY = "klijentiPrintJob";
    private static final String KLIJENTI_PRINT_TRIGGER = "klijentiPrintTrigger";

    @Bean
    public JobDetail klijentiPrintJobDetail() {
        return JobBuilder.newJob(KlijentiPrintJob.class).withIdentity(KLIJENTI_PRINT_JOB_IDENTITY)
                .storeDurably().build();
    }

    @Bean
    public SimpleTrigger klijentiPrintTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5).repeatForever();

        return TriggerBuilder.newTrigger().forJob(klijentiPrintJobDetail())
                .withIdentity(KLIJENTI_PRINT_TRIGGER).withSchedule(scheduleBuilder).build();
    }

}
