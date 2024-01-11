package com.example.tuktuk.config.db;

public enum DataSourceRole {
    READ_WRITE("rw"), //쓰기 전용
    READ_ONLY("ro"), // 읽기 전용
    TEST_ONLY("test"); // 테스트 전용

    private final String role;

    DataSourceRole(final String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
