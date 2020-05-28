package hr.tvz.zuti.autoservis.jobs;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RadniciSchedulerConfig {

    private static final String RADNICI_PRINT_JOB_IDENTITY = "radniciPrintJob";
    private static final String RADNICI_PRINT_TRIGGER = "radniciPrintTrigger";

    @Bean
    public JobDetail radniciPrintJobDetail() {
        return JobBuilder.newJob(RadniciPrintJob.class).withIdentity(RADNICI_PRINT_JOB_IDENTITY)
                .storeDurably().build();
    }

    @Bean
    public SimpleTrigger radniciPrintTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5).repeatForever();

        return TriggerBuilder.newTrigger().forJob(radniciPrintJobDetail())
                .withIdentity(RADNICI_PRINT_TRIGGER).withSchedule(scheduleBuilder).build();
    }

}
