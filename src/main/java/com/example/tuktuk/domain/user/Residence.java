package com.example.tuktuk.domain.user;

import com.example.tuktuk.domain.global.City;
import com.example.tuktuk.domain.global.Province;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
@Embeddable
public class Residence {
    @Enumerated
    @Column(name = "province")
    private Province province;

    @Enumerated
    @Column(name = "city")
    private City city;
}
