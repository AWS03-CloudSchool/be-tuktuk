package com.example.tuktuk.domain.global;

import jakarta.persistence.Column;

import java.io.Serializable;

public class ReservationId implements Serializable {
    @Column(name = "reservation_id")
    private long id;

    protected ReservationId() {

    }
}
