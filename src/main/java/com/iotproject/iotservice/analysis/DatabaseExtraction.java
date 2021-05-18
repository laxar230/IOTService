package com.iotproject.iotservice.analysis;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableAsync
@EnableScheduling
public class DatabaseExtraction {
    @Scheduled(cron = "* * * * * *")
    public void extractData(){
        System.out.println("CRON Executed");
    }
}
