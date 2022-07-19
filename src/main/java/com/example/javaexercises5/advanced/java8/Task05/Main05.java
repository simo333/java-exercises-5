package com.example.javaexercises5.advanced.java8.Task05;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Main05 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay.getDayOfWeek());
    }
}
