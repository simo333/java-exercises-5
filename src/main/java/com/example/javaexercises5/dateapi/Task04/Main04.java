package com.example.javaexercises5.dateapi.Task04;

import java.time.LocalDate;
import java.time.Period;

public class Main04 {
    public static void main(String[] args) {
        LocalDate unixEpoch = LocalDate.of(1970, 1, 1);
        LocalDate actualTime = LocalDate.now();

        System.out.println(Period.between(unixEpoch, actualTime).toTotalMonths());
    }
}
