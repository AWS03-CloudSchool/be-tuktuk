package com.example.tuktuk.stadium.controller.dto.responseDto.court;

import com.example.tuktuk.stadium.domain.court.Court;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CourtUpdateResponseDto {

    private final long courtId;

    private final String name;

    private final String courtType;

    private final int hourlyRentFee;

    public static CourtUpdateResponseDto from(Court court){
        return CourtUpdateResponseDto.builder()
                .courtId(court.getId())
                .name(court.getName())
                .courtType(court.getCourtType().name())
                .hourlyRentFee(court.getHourlyRentFee())
                .build();
    }
}
