package com.arkdex.springinaction.collectionmap.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {


    @Scheduled(fixedRate = 2000)
    public void fixedRateJob() {
        System.out.println("Something1 to be done every 2 secs");
    }


}