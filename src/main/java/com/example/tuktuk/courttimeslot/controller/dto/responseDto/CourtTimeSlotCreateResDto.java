package com.example.tuktuk.courttimeslot.controller.dto.responseDto;

import com.example.tuktuk.courttimeslot.domain.CourtTimeSlot;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Builder
public class CourtTimeSlotCreateResDto {

    private final long courtId;

    private final LocalDate playDate;

    private final LocalTime startTime;

    private final LocalTime endTime;

    private final String type;

    private final int matchRegularFee;


    public static CourtTimeSlotCreateResDto from(CourtTimeSlot courtTimeSlot) {
        return CourtTimeSlotCreateResDto.builder()
                .courtId(courtTimeSlot.getCourtId().getValue())
                .playDate(courtTimeSlot.getTime().getPlayDate())
                .startTime(courtTimeSlot.getTime().getStartTime())
                .endTime(courtTimeSlot.getTime().getEndTime())
                .type(courtTimeSlot.getType().toString())
                .matchRegularFee(courtTimeSlot.getMatchRegularFee().getValue())
                .build();
    }

}
