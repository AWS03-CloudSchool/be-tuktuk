package com.example.tuktuk.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class UserId implements Serializable {

    @Column(name = "user_id")
    private long id;

    protected UserId() {

    }
}