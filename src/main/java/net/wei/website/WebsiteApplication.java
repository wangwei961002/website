package net.wei.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.wei.website.mapper")
public class WebsiteApplication {
    public static void  main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }
}
