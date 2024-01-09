package com.example.tuktuk.domain.slice;

public enum SliceType {

    SLICE("슬라이스"),
    BORROW("경기 대여"),
    GAMEMATCH("경기 매칭");

    private String value;

    SliceType(String value) {
        this.value = value;
    }
}
