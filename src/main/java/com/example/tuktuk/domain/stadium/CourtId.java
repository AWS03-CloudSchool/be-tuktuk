package com.example.tuktuk.domain.stadium;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CourtId implements Serializable {

    @Column(name = "court_id")
    private long id;

    protected CourtId() {

    }
}
