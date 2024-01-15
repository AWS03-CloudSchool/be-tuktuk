package com.example.tuktuk.domain.courttimeslot;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Embeddable
public class Time {
    @Column(name = "play_date")
    private LocalDate playDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;
}
