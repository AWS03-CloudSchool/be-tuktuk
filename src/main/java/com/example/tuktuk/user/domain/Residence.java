package com.example.tuktuk.user.domain;

import com.example.tuktuk.global.City;
import com.example.tuktuk.global.Province;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
@Embeddable
public class Residence {
    @Enumerated(EnumType.STRING)
    @Column(name = "province")
    private Province province;

    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private City city;
}
