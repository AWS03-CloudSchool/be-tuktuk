package com.example.tuktuk.domain.field;

public enum FieldType {

    FIVE_FIVE(10,15),
    SIX_SIX(10,18);

    private final int minParticipants;
    private final int maxParticipants;

    FieldType(int minParticipants, int maxParticipants) {
        this.minParticipants = minParticipants;
        this.maxParticipants = maxParticipants;
    }
}
