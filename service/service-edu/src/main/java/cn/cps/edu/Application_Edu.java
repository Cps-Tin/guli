package cn.cps.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.cps.edu.mapper")
public class Application_Edu {
    public static void main(String[] args) {
        SpringApplication.run(Application_Edu.class);
    }
}
