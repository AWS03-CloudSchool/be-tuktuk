package com.example.tuktuk.schedule.controller.dto.responseDto;

import com.example.tuktuk.schedule.domain.Participant;
import com.example.tuktuk.schedule.domain.Schedule;
import com.example.tuktuk.schedule.domain.Time;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ScheduleReadResponseDto {

    private long courtId;

    private TimeResponseDto timeResponseDto;

    private String type;

    private List<Participant> participants;

    private String reservationStatus;

    private long matchRegularFee;

    public static ScheduleReadResponseDto from(Schedule schedule) {
        return ScheduleReadResponseDto.builder()
                .courtId(schedule.getCourtId().getValue())
                .timeResponseDto(TimeResponseDto.from(schedule.getTime()))
                .type(schedule.getType().name())
                .participants(schedule.getParticipants())
                .reservationStatus(schedule.getReservationStatus().name())
                .matchRegularFee(schedule.getMatchRegularFee().getValue())
                .build();
    }

}
