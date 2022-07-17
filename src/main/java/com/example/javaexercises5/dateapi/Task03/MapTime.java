package com.example.javaexercises5.dateapi.Task03;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapTime {
    public static Map<String, LocalTime> getMapTime() {
        Map<String, LocalTime> mapTime = new HashMap<>();
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
         return availableZoneIds.stream()
                .collect(Collectors
                        .toMap(zoneId -> zoneId, zoneId -> LocalTime.ofInstant(Instant.now(), ZoneId.of(zoneId))));
    }

}
