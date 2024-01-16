package com.example.tuktuk.stadium.controller.dto.responseDto;

import com.example.tuktuk.stadium.domain.stadium.Stadium;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.example.tuktuk.stadium.util.LocationToStringConverter.*;

@Getter
@Builder
public class SimpleStadiumResponseDto {

    private final String name;

    private final String roadAddress;

    private final List<String> imageUrl;

    private final String specificInfo;

    public static SimpleStadiumResponseDto of(Stadium stadium) {
        return SimpleStadiumResponseDto.builder()
                .name(stadium.getName())
                .roadAddress(convertLocationToString(stadium.getLocation()))
                .imageUrl(new ArrayList<>(stadium.getImages()))
                .specificInfo(stadium.getSpecificInfo())
                .build();
    }
}