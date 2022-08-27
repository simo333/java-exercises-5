package com.example.javaexercises5.dateapi.Task05;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class WorkingDayService {
    private final List<WorkingDay> workingDayList = new ArrayList<>();
    private final HolidayService holidayService;

    public WorkingDayService(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

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

    public boolean isOpen(LocalDateTime dateTime) {
        if (dateTime.getYear() != LocalDate.now().getYear()) {
            System.out.println("Podano zły rok");
            return false;
        }
        LocalDate localDate = dateTime.toLocalDate();
        if (holidayService.getHolidayByDate(localDate).isPresent()) {
            return false;
        }
        if (!holidayService.getTradeSundayByDate(localDate)) {
            return false;
        }

        WorkingDay day = getByDayOfWeek(dateTime.getDayOfWeek());
        if (day.getOpenTime() == null || day.getCloseTime() == null) {
            return false;
        }
        LocalTime localTime = dateTime.toLocalTime();
        return localTime.isAfter(day.getOpenTime()) && localTime.isBefore(day.getCloseTime());
    }

    public Duration timeToOpen(LocalDateTime time) {
        DayOfWeek dayOfWeek = time.getDayOfWeek();
        WorkingDay workingDay = getByDayOfWeek(dayOfWeek);
        if (time.toLocalTime().isAfter(workingDay.getCloseTime())) {
            LocalDateTime nextOpenDateTime = getClosestWorkingDay(time);
            return Duration.between(time, nextOpenDateTime);
        }
        return Duration.between(time, workingDay.getOpenTime());
    }

    public Duration timeToClose(LocalDateTime dateTime) {
        WorkingDay workingDay = getByDayOfWeek(dateTime.getDayOfWeek());
        Duration between = Duration.between(dateTime.toLocalTime(), workingDay.getCloseTime());
        if (between.isNegative()) {
            between = between.plusDays(1);
        }
        return between;
    }

    public LocalDateTime getClosestWorkingDay(LocalDateTime since) {
        LocalDate closestWorkingDay = since.toLocalDate().plusDays(1);
        while (holidayService.getHolidayByDate(closestWorkingDay).isPresent()
                || getByDayOfWeek(closestWorkingDay.getDayOfWeek()).getOpenTime() == null
                || holidayService.getTradeSundayByDate(closestWorkingDay)) {
            closestWorkingDay = closestWorkingDay.plusDays(1);
        }
        return LocalDateTime.of(closestWorkingDay,
                getByDayOfWeek(closestWorkingDay.getDayOfWeek()).getOpenTime());
    }
}
