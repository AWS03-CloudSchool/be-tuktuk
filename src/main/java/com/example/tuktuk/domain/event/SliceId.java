package com.example.tuktuk.domain.event;

import jakarta.persistence.Column;

import java.io.Serializable;

public class SliceId implements Serializable {

    @Column(name = "slice_id")
    private long id;

    protected SliceId() {

    }
}
