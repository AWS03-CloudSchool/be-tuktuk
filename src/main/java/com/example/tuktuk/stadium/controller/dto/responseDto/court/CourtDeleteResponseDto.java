package com.example.tuktuk.stadium.controller.dto.responseDto.court;

import com.example.tuktuk.stadium.domain.court.Court;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CourtDeleteResponseDto {

  private final long courtId;

  private final String courtName;

  private final String stadiumName;

  private final String courtType;

  private int hourlyRentFee;

  public static CourtDeleteResponseDto from(Court court) {
    return CourtDeleteResponseDto.builder()
        .courtId(court.getId())
        .courtName(court.getName())
        .stadiumName(court.getStadium().getName())
        .courtType(court.getCourtType().name())
        .hourlyRentFee(court.getHourlyRentFee())
        .build();
  }
}
