package com.example.tuktuk.domain.global;

import static com.example.tuktuk.domain.global.Province.*;
import static com.example.tuktuk.domain.global.Province.SEOUL;

public enum City {
    GANGNAM(SEOUL, "강남"), SEOCHO(SEOUL, "서초"), Songpa(SEOUL, "송파"),
    UIWAING(GYEONGGI, "의왕"), ANYANG(GYEONGGI, "안양");

    private final Province province;
    private final String city;

    City(Province province, String city) {
        this.province = province;
        this.city = city;
    }
}
