package com.example.tuktuk.stadium.controller;

import com.example.tuktuk.stadium.controller.dto.responseDto.SimpleStadiumResponseDto;
import com.example.tuktuk.stadium.service.StadiumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("stadium")
@RequiredArgsConstructor
@Slf4j
public class StadiumController {

    @Autowired
    private final StadiumService stadiumService;

    @GetMapping("/{stadiumId}")
    public SimpleStadiumResponseDto getSimpleStadium(@PathVariable Long stadiumId){
        return stadiumService.findByStadiumId(stadiumId);
    }
}
