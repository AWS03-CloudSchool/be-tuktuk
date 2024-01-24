package com.example.tuktuk.stadium.controller.dto.requestDto.court;

import lombok.Getter;

@Getter
public class CourtUpdateRequestDto {

    private String name;

    private String courtType;

    private int hourlyRentFee;
}
