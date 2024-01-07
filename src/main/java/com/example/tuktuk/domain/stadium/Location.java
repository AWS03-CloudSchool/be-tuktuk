package com.example.tuktuk.domain.stadium;

import com.example.tuktuk.domain.global.City;
import com.example.tuktuk.domain.global.Province;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
@Embeddable
public class Location {

    @Enumerated
    @Column(name = "province")
    private Province province;//도 또는 시

    @Enumerated
    @Column(name = "city")
    private City city;//시, 군, 구 등

    @Column(name = "road_address")
    private String roadNameAddress;//도로명 주소
}
