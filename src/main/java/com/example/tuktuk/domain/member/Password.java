package com.example.tuktuk.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Password {
    @Column(name = "password",nullable = false)
    private String value;
}
