package com.example.tuktuk.schedule.controller.dto.responseDto;

import com.example.tuktuk.schedule.domain.Schedule;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@Builder
public class ScheduleSimpleReadResDto {

    private String courtName;

    private TimeResponseDto timeResponseDto;

    private String type;

    public static ScheduleSimpleReadResDto from(Schedule schedule, String courtName){
        return ScheduleSimpleReadResDto.builder()
                .courtName(courtName)
                .timeResponseDto(TimeResponseDto.from(schedule.getTime()))
                .type(schedule.getType().name())
                .build();
    }
}
