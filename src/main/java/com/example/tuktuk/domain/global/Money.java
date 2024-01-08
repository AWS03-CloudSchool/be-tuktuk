package com.example.tuktuk.domain.global;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Money {

    @Column(name = "value")
    private int value;

}
