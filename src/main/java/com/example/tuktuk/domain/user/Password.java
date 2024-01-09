package com.example.tuktuk.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Password {
    @Column(name = "password",nullable = false)
    private String value;
}
