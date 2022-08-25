package com.example.javaexercises5.dateapi.Task05;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class WorkingDayService {
    private final List<WorkingDay> workingDayList = new ArrayList<>();

    public WorkingDay getByDayOfWeek(DayOfWeek dayOfWeek) {
        return workingDayList.stream()
                .filter(workingDay -> workingDay.getDayOfWeek().equals(dayOfWeek))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Day not configured, For day: " + dayOfWeek));
    }

    public void setWorkingDayOpenHours(DayOfWeek dayOfWeek, String time) {
        String[] times = time.split("-");
        try {
            LocalTime openTime = LocalTime.parse(times[0], DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime closeTime = LocalTime.parse(times[1], DateTimeFormatter.ofPattern("HH:mm"));
            workingDayList.add(new WorkingDay(dayOfWeek, openTime, closeTime));
        } catch (DateTimeParseException e) {
            setDayOff(dayOfWeek);
        }

    }

    public void setWorkingDayOpenHours(DayOfWeek dayOfWeek, LocalTime openTime, LocalTime closeTime) {
        workingDayList.add(new WorkingDay(dayOfWeek, openTime, closeTime));
    }

    public void setDayOff(DayOfWeek dayOfWeek) {
        workingDayList.add(new WorkingDay(dayOfWeek, null, null));
    }

    public boolean isOpen(DayOfWeek dayOfWeek, LocalTime time) {
        WorkingDay day = getByDayOfWeek(dayOfWeek);
        if (day.getOpenTime() == null || day.getCloseTime() == null) {
            return false;
        }
        return time.isAfter(day.getOpenTime()) && time.isBefore(day.getCloseTime());
    }

    public Duration timeToOpen(DayOfWeek dayOfWeek, LocalTime time) {
        WorkingDay workingDay = getByDayOfWeek(dayOfWeek);
        if(time.isAfter(workingDay.getCloseTime())) {
            DayOfWeek dayAfter = DayOfWeek.of(dayOfWeek.getValue() + 1);
            return Duration.between(time, getByDayOfWeek(dayAfter).getOpenTime());
        }
        if(time.isBefore(workingDay.getOpenTime())) {
            return Duration.between(time, workingDay.getOpenTime());
        }
        throw new IllegalArgumentException("Probably open. For inputs: " + dayOfWeek + ", " + time);
    }

    public Duration timeToClose(DayOfWeek dayOfWeek, LocalTime time) {
        WorkingDay workingDay = getByDayOfWeek(dayOfWeek);
        return Duration.between(time, workingDay.getCloseTime());
    }

}
