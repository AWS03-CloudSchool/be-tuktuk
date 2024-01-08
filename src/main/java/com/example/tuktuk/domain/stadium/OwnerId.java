package com.example.tuktuk.domain.stadium;

import jakarta.persistence.Column;

import java.io.Serializable;

public class OwnerId implements Serializable {
    @Column(name = "owner_id")
    private long id;

    protected OwnerId() {

    }
}
