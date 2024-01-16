package com.example.tuktuk.stadium.controller.dto.requestDto;

import lombok.Getter;

@Getter
public class StadiumUpdateRequestDto {

    private String name;

    private LocationReqDto locationReqDto;

    private String specificInfo;

}
