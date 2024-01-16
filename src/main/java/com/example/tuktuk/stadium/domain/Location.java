package com.example.tuktuk.stadium.domain;

import com.example.tuktuk.global.City;
import com.example.tuktuk.global.Province;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
@Embeddable
public class Location {

    @Enumerated(EnumType.STRING)
    @Column(name = "province")
    private Province province;

    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private City city;

    @Column(name = "road_address")
    private String roadNameAddress;
}
