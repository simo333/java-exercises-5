package com.example.javaexercises5.dateapi.Task05;

import java.time.LocalDate;

public class Holiday {
    private String localName;
    private LocalDate date;


    public Holiday(String localName, LocalDate date) {
        this.localName = localName;
        this.date = date;
    }

    public Holiday(String localName, String date) {
        this.localName = localName;
        setDateFromString(date);
    }

    public Holiday() {
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDateFromString(String date) {
        String[] splitDate = date.split("-");
        this.date = LocalDate.of(Integer.parseInt(splitDate[0]),
                Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[2]));
    }

    @Override
    public String toString() {
        return "Święto: " + localName + " - " + date;
    }
}
