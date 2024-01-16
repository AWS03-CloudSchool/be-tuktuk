package com.example.tuktuk.stadium.controller.dto.requestDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LocationReqDto {

    private String province;

    private String city;

    private String roadNameAddress;
}
