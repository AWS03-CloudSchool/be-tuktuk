package com.example.tuktuk.domain.courttimeslot;

import jakarta.persistence.Column;

import java.io.Serializable;

public class CourtTimeSlotId implements Serializable {

    @Column(name = "court_time_slot_id")
    private long id;

    protected CourtTimeSlotId() {

    }
}