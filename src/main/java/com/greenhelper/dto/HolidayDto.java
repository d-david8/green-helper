package com.greenhelper.dto;

import java.time.LocalDate;

public class HolidayDto {
    private String name;
    private LocalDate date;
    private String dayOfWeek;

    public HolidayDto(String name, LocalDate date) {
        this.name = name;
        this.date = date;
        this.dayOfWeek = date.getDayOfWeek().toString();
    }

    // Getters și setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
        this.dayOfWeek = date.getDayOfWeek().toString();
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}