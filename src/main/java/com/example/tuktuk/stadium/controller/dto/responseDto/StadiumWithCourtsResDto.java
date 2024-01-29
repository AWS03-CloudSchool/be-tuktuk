package com.example.tuktuk.stadium.controller.dto.responseDto;

import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtReadResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumReadResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class StadiumWithCourtsResDto {

    private StadiumReadResponseDto stadiumReadResDto;

    private List<CourtReadResponseDto> courtReadResDto;
}
