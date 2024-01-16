package com.example.tuktuk.stadium.controller.dto.requestDto;

import com.example.tuktuk.user.domain.UserId;
import lombok.Getter;

@Getter
public class StadiumUpdateRequestDto {

    private String name;

    private UserId ownerId;

    private LocationReqDto locationReqDto;

    private String specificInfo;

}
