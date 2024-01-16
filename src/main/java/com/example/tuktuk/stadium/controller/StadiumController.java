package com.example.tuktuk.stadium.controller;

import com.example.tuktuk.stadium.controller.dto.requestDto.StadiumRegistrationRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.SimpleStadiumResponseDto;
import com.example.tuktuk.stadium.service.StadiumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StadiumController {

    @Autowired
    private final StadiumService stadiumService;

    @GetMapping(value = "/stadium/{stadiumId}")
    public SimpleStadiumResponseDto getSimpleStadium(@PathVariable Long stadiumId){
        return stadiumService.findByStadiumId(stadiumId);
    }

    @PostMapping(value = "/stadium")
    public StadiumRegistrationRequestDto registryStadium(@RequestBody StadiumRegistrationRequestDto stadiumRegistrationRequestDto){
        return stadiumRegistrationRequestDto;
    }
}
