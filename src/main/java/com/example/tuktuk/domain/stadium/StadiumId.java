package com.example.tuktuk.domain.stadium;

import jakarta.persistence.Column;

import java.io.Serializable;

public class StadiumId implements Serializable {

    @Column(name = "stadium_id")
    private long id;

    protected StadiumId() {

    }
}
