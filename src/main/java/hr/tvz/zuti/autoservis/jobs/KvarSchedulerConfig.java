package hr.tvz.zuti.autoservis.jobs;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KvarSchedulerConfig {

    private static final String KVAR_PRINT_JOB_IDENTITY = "kvarPrintJob";
    private static final String KVAR_PRINT_TRIGGER = "kvarPrintTrigger";

    @Bean
    public JobDetail kvaroviPrintJobDetail() {
        return JobBuilder.newJob(KvarPrintJob.class).withIdentity(KVAR_PRINT_JOB_IDENTITY)
                .storeDurably().build();
    }

    @Bean
    public SimpleTrigger kvaroviPrintTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();

        return TriggerBuilder.newTrigger().forJob(kvaroviPrintJobDetail())
                .withIdentity(KVAR_PRINT_TRIGGER).withSchedule(scheduleBuilder).build();
    }

}