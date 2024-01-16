package com.example.tuktuk.stadium.controller.dto.responseDto;

import com.example.tuktuk.stadium.domain.stadium.Stadium;
import lombok.Builder;
import lombok.Getter;

import static com.example.tuktuk.stadium.util.LocationToStringConverter.convertLocationToString;

@Getter
@Builder
public class StadiumUpdateResponseDto {
    private final String name;

    private final String roadAddress;

    private final String ownerName;

    private final String specificInfo;

    public static StadiumUpdateResponseDto from(Stadium stadium) {
        return StadiumUpdateResponseDto.builder()
                .name(stadium.getName())
                .roadAddress(convertLocationToString(stadium.getLocation()))
                .ownerName(stadium.getName())
                .specificInfo(stadium.getSpecificInfo())
                .build();
    }
}