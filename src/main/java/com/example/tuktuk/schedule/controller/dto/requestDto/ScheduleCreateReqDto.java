package com.example.tuktuk.schedule.controller.dto.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleCreateReqDto {

    private long courtId;

    private String playDate;

    private String startTime;

    private String endTime;

    private String type;//매치 or 대여 or both
}







