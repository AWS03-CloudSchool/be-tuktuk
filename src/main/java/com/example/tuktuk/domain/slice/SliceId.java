package com.example.tuktuk.domain.slice;

import jakarta.persistence.Column;

import java.io.Serializable;

public class SliceId implements Serializable {

    @Column(name = "slice_id")
    private long id;

    protected SliceId() {

    }
}
