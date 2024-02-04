package com.example.tuktuk.users.domain;

public enum Provider {

    KAKAO("카카오"),
    GOOGLE("구글"),
    NAVER("네이버"),
    OUR("일반");
    private String name;

    Provider(String name) {
        this.name = name;
    }
}
