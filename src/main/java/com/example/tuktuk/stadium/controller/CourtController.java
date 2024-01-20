package com.example.tuktuk.stadium.controller;

import com.example.tuktuk.stadium.controller.dto.requestDto.court.CourtCreateRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtCreateResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtReadResponseDto;
import com.example.tuktuk.stadium.service.CourtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/courts")
@RequiredArgsConstructor
@Slf4j
public class CourtController {
  @Autowired
  private CourtService courtService;

  @GetMapping("/{courtId}")
  public CourtReadResponseDto getCourtById(@PathVariable Long courtId){
    return courtService.findByCourtId(courtId);
  }

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public CourtCreateResponseDto createCourt(@RequestPart("courtCreateRequest") CourtCreateRequestDto request,
                                            @RequestPart(value = "images", required = false) List<MultipartFile> images){
    return courtService.saveCourt(request, images);
  }

  @PatchMapping(value = "/{stadiumId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateCourt(){

  }

  @DeleteMapping("/{stadiumId}")
  public void deleteCourt(){

  }
}
