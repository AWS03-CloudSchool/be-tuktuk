package com.example.tuktuk.domain.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public abstract class SliceTime {

    private final LocalTime startTime;
    private final LocalTime endTime;
    private final SliceTimeStatus sliceTimeStatus;
}
