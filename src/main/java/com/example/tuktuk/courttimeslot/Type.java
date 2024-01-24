package com.example.tuktuk.courttimeslot;

public enum Type {

    NONE("없음"),
    MATCH("매치"),
    RENTAL("대여");

    private String value;

    Type(String value) {
        this.value = value;
    }
}
