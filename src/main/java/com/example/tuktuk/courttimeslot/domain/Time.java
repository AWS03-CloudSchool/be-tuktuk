package com.example.tuktuk.courttimeslot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Builder
@Embeddable
public class Time {

    protected Time() {
    }

    public Time(LocalDate playDate, LocalTime startTime, LocalTime endTime) {
        this.playDate = playDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Column(name = "play_date")
    private LocalDate playDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;
}
