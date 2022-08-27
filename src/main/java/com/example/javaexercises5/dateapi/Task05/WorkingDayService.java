package com.example.javaexercises5.dateapi.Task05;

import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class WorkingDayService {
    private final List<WorkingDay> workingDayList = new ArrayList<>();
    private final HolidayService holidayService = new HolidayService();

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

    public Duration timeToOpen(LocalDateTime time) {
        DayOfWeek dayOfWeek = time.getDayOfWeek();
        WorkingDay workingDay = getByDayOfWeek(dayOfWeek);
        LocalTime time2 = time.toLocalTime();
        Duration duration = Duration.between(time2, workingDay.getOpenTime());
        if(duration.isNegative()) {
            duration = duration.plusDays(1);
        }
        return duration;
    }

    public Duration timeToClose(DayOfWeek dayOfWeek, LocalTime time) {
        WorkingDay workingDay = getByDayOfWeek(dayOfWeek);
        Duration between = Duration.between(time, workingDay.getCloseTime());
        if(between.isNegative()) {
            between = between.plusDays(1);
        }
        return between;
    }

}
