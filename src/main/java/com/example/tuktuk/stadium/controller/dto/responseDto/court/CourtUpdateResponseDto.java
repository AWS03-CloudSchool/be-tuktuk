package com.example.tuktuk.stadium.controller.dto.responseDto.court;

import com.example.tuktuk.stadium.domain.court.Court;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CourtUpdateResponseDto {

    private String name;

    private String courtType;

    private int hourlyRentFee;

    public static CourtUpdateResponseDto from(Court court){
        return CourtUpdateResponseDto.builder()
                .name(court.getName())
                .courtType(court.getCourtType().name())
                .hourlyRentFee(court.getHourlyRentFee())
                .build();
    }
}
