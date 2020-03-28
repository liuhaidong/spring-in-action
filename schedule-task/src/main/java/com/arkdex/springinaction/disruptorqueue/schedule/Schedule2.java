package com.arkdex.springinaction.disruptorqueue.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule2 {

    @Scheduled(cron = "0 * * * * *")
    public void fixedRateJob() {
        System.out.println("Something2 to be done every 2 secs");
    }

}
