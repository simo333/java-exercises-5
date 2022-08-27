package com.example.javaexercises5.dateapi.Task06;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main06 {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2022, 8, 27, 18, 0);
        LocalDateTime dateTime2 = LocalDateTime.of(2022, 8, 28, 9, 0);
        LocalDateTime dateTime3 = LocalDateTime.of(dateTime.toLocalDate().plusDays(1), LocalTime.of(0,0));
        System.out.println(Duration.between(dateTime, dateTime3));
    }
}
