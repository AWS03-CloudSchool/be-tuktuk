package com.example.tuktuk.domain.global;

public enum Province {

    SEOUL("서울"),
    GYEONGGI("경기"),
    BUSAN("부산"),
    DAEGU("대구"),
    INCHEON("인천"),
    GWANGJU("광주"),
    DAEJEON("대전");
    private final String province;

    Province(String province) {
        this.province = province;
    }
}
