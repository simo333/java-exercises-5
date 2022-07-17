package com.example.javaexercises5.dateapi.Task01;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

public class Main01 {
    public static void main(String[] args) {
        List<String> europeZoneIds = ZoneId.getAvailableZoneIds().stream()
                .filter(tz -> tz.contains("Europe"))
                .toList();

        europeZoneIds.stream()
                .map(tz -> tz + ": " + LocalTime.ofInstant(Instant.now(), ZoneId.of(tz)))
                .sorted()
                .forEach(System.out::println);
    }
}
