package com.example.tuktuk.domain.stadium;

import com.example.tuktuk.domain.global.City;
import com.example.tuktuk.domain.global.Province;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Getter
@Embeddable
public class Location {

    @Enumerated
    @Column(name = "province")
    private Province province;

    @Enumerated
    @Column(name = "city")
    private City city;

    @Column(name = "road_address")
    private String roadNameAddress;
}
