package com.example.pollingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PollingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PollingAppApplication.class, args);
    }

}
