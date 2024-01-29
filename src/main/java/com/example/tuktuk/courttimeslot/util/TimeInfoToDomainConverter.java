package com.example.tuktuk.courttimeslot.util;

import com.example.tuktuk.courttimeslot.domain.Time;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeInfoToDomainConverter {

    private TimeInfoToDomainConverter() {
    }

    public static Time convertTimeInfoToDomain(LocalDate playDate, LocalTime startTime, LocalTime endTime) {
        return Time.builder()
                .playDate(playDate)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
