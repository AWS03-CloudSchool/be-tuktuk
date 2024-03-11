package com.example.tuktuk.stadium.controller.dto.responseDto;

import com.example.tuktuk.global.PageInfo;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtReadResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.CourtReadSimpleResDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumReadResponseDto;
import com.example.tuktuk.stadium.domain.court.Court;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Builder
@Getter
public class StadiumWithCourtsResDto {

    private StadiumReadResponseDto stadium;

    private List<CourtReadSimpleResDto> courts;

    private PageInfo pageInfo;

    public static StadiumWithCourtsResDto from(StadiumReadResponseDto stadium,
                                               Page<Court> courts){
        return StadiumWithCourtsResDto.builder()
                .stadium(stadium)
                .courts(courts.get().map(CourtReadSimpleResDto::from).toList())
                .pageInfo(PageInfo.from(courts))
                .build();
    }
}
