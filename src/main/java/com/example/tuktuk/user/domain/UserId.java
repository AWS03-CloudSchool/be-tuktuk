package com.example.tuktuk.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserId implements Serializable {

    @Column(name = "user_id")
    private long id;

    protected UserId(long id) {
        this.id = id;
    }
}
