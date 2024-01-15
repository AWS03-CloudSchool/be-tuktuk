package com.example.tuktuk.domain.courttimeslot;

public enum ReservationStatus {

    AVAILABLE("예약 가능"),
    UNAVAILABLE("예약 불가능");

    private final String value;

    ReservationStatus(String value) {
        this.value = value;
    }
}
