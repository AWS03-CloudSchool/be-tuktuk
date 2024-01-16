package com.example.tuktuk.stadium.controller.dto.responseDto;

import com.example.tuktuk.stadium.domain.stadium.Stadium;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.example.tuktuk.stadium.util.LocationToStringConverter.convertLocationToString;

@Getter
@Builder
public class StadiumCreateResponseDto {

    private final String name;

    private final String roadAddress;

    private final String ownerName;

    private final List<String> imageUrl;

    private final String specificInfo;

    public static StadiumCreateResponseDto from (Stadium stadium) {
        return StadiumCreateResponseDto.builder()
                .name(stadium.getName())
                .roadAddress(convertLocationToString(stadium.getLocation()))
                .ownerName(stadium.getName())
                .imageUrl(new ArrayList<>(stadium.getImages()))
                .specificInfo(stadium.getSpecificInfo())
                .build();
    }
}
