package com.example.javaexercises5.dateapi.Task06;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main06 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());
        ZonedDateTime zonedDateTime2 = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC-2"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime.isEqual(zonedDateTime2));
    }
}
