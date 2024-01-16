package com.example.tuktuk.stadium.controller.dto.requestDto;

import com.example.tuktuk.global.City;
import com.example.tuktuk.global.Province;
import com.example.tuktuk.stadium.domain.Location;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LocationReqDto {

    private String province;

    private String city;

    private String roadNameAddress;

    public Location toEntity(){
        return Location.builder()
            .province(Province.valueOf(province))
            .city(City.valueOf(city))
            .roadNameAddress(roadNameAddress)
            .build();
    }
}
