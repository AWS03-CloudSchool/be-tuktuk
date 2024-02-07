package com.example.tuktuk.stadium.controller;

import com.example.tuktuk.stadium.controller.dto.requestDto.stadium.StadiumCreateRequestDto;
import com.example.tuktuk.stadium.controller.dto.requestDto.stadium.StadiumUpdateRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.StadiumWithCourtsResDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtReadResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumCreateResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumDeleteResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumReadResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumUpdateResponseDto;
import com.example.tuktuk.stadium.service.CourtService;
import com.example.tuktuk.stadium.service.StadiumService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stadiums")
@RequiredArgsConstructor
@Slf4j
public class StadiumController {

    private final StadiumService stadiumService;

    private final CourtService courtService;

    @GetMapping("/{stadiumId}")
    public StadiumReadResponseDto getStadiumById(@PathVariable(name = "stadiumId") long stadiumId) {
        return stadiumService.findByStadiumId(stadiumId);
    }

    @GetMapping("/{stadiumId}/courts")
    public StadiumWithCourtsResDto getStadiumWithCourts(@PathVariable(name = "stadiumId") long stadiumId) {
        StadiumReadResponseDto stadiumResDto = stadiumService.findByStadiumId(stadiumId);
        List<CourtReadResponseDto> courtResDto = courtService.findByStadiumId(stadiumId);

        return StadiumWithCourtsResDto.builder()
                .stadiumReadResDto(stadiumResDto)
                .courtReadResDto(courtResDto)
                .build();
    }

    @GetMapping()
    public List<StadiumReadResponseDto> getStadiumsByOwnerId(@RequestParam(name = "ownerId") String ownerId) {
        return stadiumService.findByOwnerId(ownerId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public StadiumCreateResponseDto createStadium(@RequestBody StadiumCreateRequestDto requestDto, HttpServletRequest request) {
        String ownerId = (String) request.getAttribute("id");
        return stadiumService.saveStadium(ownerId, requestDto);
    }

    @PatchMapping(value = "/{stadiumId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public StadiumUpdateResponseDto updateStadium(@PathVariable(name = "stadiumId") long stadiumId,
                                                  @RequestBody StadiumUpdateRequestDto requestDto,
                                                  HttpServletRequest request) {
        String ownerId = (String) request.getAttribute("id");
        return stadiumService.updateStadium(ownerId, stadiumId, requestDto);
    }

    @DeleteMapping("/{stadiumId}")
    public StadiumDeleteResponseDto deleteStadium(@PathVariable(name = "stadiumId") long stadiumId) {
        return stadiumService.deleteStadium(stadiumId);
    }
}
