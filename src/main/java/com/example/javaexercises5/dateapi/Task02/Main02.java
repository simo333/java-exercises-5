package com.example.javaexercises5.dateapi.Task02;

import java.time.LocalDate;
import java.time.Month;

public class Main02 {
    public static void main(String[] args) {
        getDayNamesOfFChristmas();
    }

    static void getDayNamesOfFChristmas() {
        LocalDate actualDate = LocalDate.now();
        for (int i = 0; i < 10; i++) {
            int checkYear = i + actualDate.getYear();
            System.out.println(checkYear + ": " +
                    LocalDate.of(checkYear, Month.DECEMBER, 24).getDayOfWeek());
        }
    }
}
