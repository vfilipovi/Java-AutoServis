package hr.tvz.zuti.autoservis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class AutoservisApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoservisApplication.class, args);
    }

}
