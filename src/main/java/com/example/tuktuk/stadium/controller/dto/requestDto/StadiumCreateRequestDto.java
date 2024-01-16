package com.example.tuktuk.stadium.controller.dto.requestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class StadiumCreateRequestDto {

    private String name;

    private LocationReqDto locationReqDto;

    private String specificInfo;
}
