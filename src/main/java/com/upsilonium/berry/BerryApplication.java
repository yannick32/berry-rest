package com.upsilonium.berry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class BerryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BerryApplication.class, args);
    }

}
