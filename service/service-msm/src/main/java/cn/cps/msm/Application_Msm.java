package cn.cps.msm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("cn.cps")
public class Application_Msm {

    public static void main(String[] args) {
        SpringApplication.run(Application_Msm.class, args);
    }
}
