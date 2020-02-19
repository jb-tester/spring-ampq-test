package com.mytests.spring.ampq.springampqtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringAmpqTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAmpqTestApplication.class, args);
    }

}
