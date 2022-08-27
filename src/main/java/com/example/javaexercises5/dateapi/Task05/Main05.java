package com.example.javaexercises5.dateapi.Task05;

import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main05 {
    public static void main(String[] args) {
//        OpenCloseValidator openCloseValidator = new OpenCloseValidator();
//        openCloseValidator.configureWork(Paths.get("src/main/resources/config.txt"));
//        openCloseValidator.checkOIfOpen(LocalDateTime.of(2022, 4, 16, 18, 0));

        LocalTime time1 = LocalTime.of(18,0);
        LocalTime time2 = LocalTime.of(9,0);
        Duration timeToMidnight = Duration.between(time1, LocalTime.MIDNIGHT);
        if(timeToMidnight.isNegative()) {
            timeToMidnight = timeToMidnight.plusDays(1);
        }
        Duration timeSinceMidnight = Duration.between(LocalTime.MIDNIGHT, time2);
        System.out.println(timeToMidnight);
        System.out.println(timeSinceMidnight);
        System.out.println(timeToMidnight.plus(timeSinceMidnight));

    }
}
