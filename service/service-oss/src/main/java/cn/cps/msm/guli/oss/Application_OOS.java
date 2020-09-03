package cn.cps.msm.guli.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//解决Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Application_OOS {

    public static void main(String[] args) {
        SpringApplication.run(Application_OOS.class);
    }

}
