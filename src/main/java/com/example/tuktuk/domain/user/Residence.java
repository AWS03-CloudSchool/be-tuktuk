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
    private Province province;//도 또는 시

    @Enumerated
    @Column(name = "city")
    private City city;//시, 군, 구 등
}
