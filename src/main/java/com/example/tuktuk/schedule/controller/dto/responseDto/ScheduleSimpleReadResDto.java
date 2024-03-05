package com.example.tuktuk.schedule.controller.dto.responseDto;

import com.example.tuktuk.schedule.domain.Schedule;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@Builder
public class ScheduleSimpleReadResDto {

    private String stadiumWithCourtName;

    private TimeResponseDto timeResponseDto;

    private String type;

    public static ScheduleSimpleReadResDto from(Schedule schedule, String stadiumWithCourtName){
        return ScheduleSimpleReadResDto.builder()
                .stadiumWithCourtName(stadiumWithCourtName)
                .timeResponseDto(TimeResponseDto.from(schedule.getTime()))
                .type(schedule.getType().name())
                .build();
    }
}
