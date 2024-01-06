package com.example.tuktuk.domain.borrow;

public enum BorrowStatus {
    AVAILABLE("예약 가능"),
    UNAVAILABLE("예약 불가");

    private final String displayName;

    BorrowStatus(String displayName) {
        this.displayName = displayName;
    }
}
