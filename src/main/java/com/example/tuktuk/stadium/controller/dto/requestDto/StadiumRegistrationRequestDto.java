package com.example.tuktuk.stadium.controller.dto.requestDto;

import com.example.tuktuk.stadium.domain.stadium.Stadium;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class StadiumRegistrationRequestDto {
    private String name;
    private Long ownerId;
    private List<String> imageUrl;
    private LocationDto location;
    private String specificInfo;
}
