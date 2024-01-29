package com.example.tuktuk.courttimeslot.controller.dto.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor
public class CourtTimeSlotCreateReqDto {

    private long courtId;

    private LocalDate playDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private String type;//매치 or 대여 or both
}







