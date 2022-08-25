package com.example.javaexercises5.dateapi.Task05;


import java.util.Set;

public class OpenCloseValidator {

    private final HolidayDays holidayDays;
    private final Set<WorkingDayHours> workingDayHoursSet;

    public OpenCloseValidator(HolidayDays holidayDays, Set<WorkingDayHours> workingDayHoursSet) {
        this.holidayDays = holidayDays;
        this.workingDayHoursSet = workingDayHoursSet;
    }


}
