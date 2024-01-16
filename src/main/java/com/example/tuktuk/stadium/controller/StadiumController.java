package com.example.tuktuk.stadium.controller;

import com.example.tuktuk.global.Message;
import com.example.tuktuk.stadium.controller.dto.requestDto.StadiumCreateRequestDto;
import com.example.tuktuk.stadium.controller.dto.requestDto.StadiumUpdateRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.StadiumCreateResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.StadiumReadResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.StadiumUpdateResponseDto;
import com.example.tuktuk.stadium.service.StadiumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stadium")
@RequiredArgsConstructor
@Slf4j
public class StadiumController {

    @Autowired
    private final StadiumService stadiumService;

    @GetMapping("/{stadiumId}/info")
    public StadiumReadResponseDto showStadiumById(@PathVariable Long stadiumId) {
        return stadiumService.findByStadiumId(stadiumId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public StadiumCreateResponseDto createStadium(@RequestBody StadiumCreateRequestDto request) {
        return stadiumService.saveStadium(request);
    }

    @PatchMapping(value = "/{stadiumId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public StadiumUpdateResponseDto updateStadium(@PathVariable Long stadiumId, @RequestBody StadiumUpdateRequestDto requestDto) {
        return stadiumService.updateStadium(stadiumId, requestDto);
    }

    @DeleteMapping("/{stadiumId}")
    public Message deleteStadium(@PathVariable Long stadiumId) {
        stadiumService.deleteStadium(stadiumId);

        return Message.builder()
                .message("성공")
                .status(HttpStatus.OK)
                .code(0)
                .build();
    }

}
