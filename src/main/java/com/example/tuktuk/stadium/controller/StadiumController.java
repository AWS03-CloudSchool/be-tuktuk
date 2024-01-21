package com.example.tuktuk.stadium.controller;

import com.example.tuktuk.global.Message;
import com.example.tuktuk.stadium.controller.dto.requestDto.stadium.StadiumCreateRequestDto;
import com.example.tuktuk.stadium.controller.dto.requestDto.stadium.StadiumUpdateRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumCreateResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumReadResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumUpdateResponseDto;
import com.example.tuktuk.stadium.service.StadiumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stadiums")
@RequiredArgsConstructor
@Slf4j
public class StadiumController {

    @Autowired
    private final StadiumService stadiumService;

    @GetMapping("/{stadiumId}")
    public StadiumReadResponseDto getStadiumById(@PathVariable(name = "stadiumId") long stadiumId) {
        return stadiumService.findByStadiumId(stadiumId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public StadiumCreateResponseDto createStadium(@RequestBody StadiumCreateRequestDto request) {
        return stadiumService.saveStadium(request);
    }

    @PatchMapping(value = "/{stadiumId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public StadiumUpdateResponseDto updateStadium(@PathVariable(name = "stadiumId") long stadiumId,
                                                  @RequestBody StadiumUpdateRequestDto requestDto) {
        return stadiumService.updateStadium(stadiumId, requestDto);
    }

    @DeleteMapping("/{stadiumId}")
    public void deleteStadium(@PathVariable(name = "stadiumId") long stadiumId) {
        stadiumService.deleteStadium(stadiumId);
    }
}
