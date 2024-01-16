package com.example.tuktuk.stadium.controller.dto.requestDto;

import com.example.tuktuk.stadium.domain.stadium.Stadium;
import com.example.tuktuk.user.domain.UserId;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StadiumCreateRequestDto {

    private String name;

    private UserId ownerId;

    private List<String> imageUrl;

    private LocationReqDto locationReqDto;

    private String specificInfo;

    public Stadium of() {
        return Stadium.builder()
                .name(name)
                .ownerId(ownerId)
                .location(locationReqDto.of())
                .specificInfo(specificInfo)
                .images(imageUrl)
                .build();
    }
}
