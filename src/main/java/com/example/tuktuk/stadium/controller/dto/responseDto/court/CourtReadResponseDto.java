package com.example.tuktuk.stadium.controller.dto.responseDto.court;

import com.example.tuktuk.stadium.domain.court.Court;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CourtReadResponseDto {

  private final String stadiumName;

  private final String courtName;

  private final String courtType;

  private final int hourlyRentFee;

  private final List<String> images;

  public static CourtReadResponseDto from(Court court){
    return CourtReadResponseDto.builder()
        .stadiumName(court.getStadium().getName())
        .courtName(court.getName())
        .courtType(court.getCourtType().toString())
        .hourlyRentFee(court.getHourlyRentFee())
        .images(court.getImages())
        .build();
  }
}
