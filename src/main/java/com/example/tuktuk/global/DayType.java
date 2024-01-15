package com.example.tuktuk.global;

public enum DayType {

    WEEKDAY("평일"),
    WEEKEND("주말");

    private final String value;

    DayType(String value) {
        this.value = value;
    }
}
