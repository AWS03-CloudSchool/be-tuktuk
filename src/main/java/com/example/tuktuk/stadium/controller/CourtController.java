package com.example.tuktuk.stadium.controller;

import com.example.tuktuk.stadium.controller.dto.requestDto.court.CourtCreateRequestDto;
import com.example.tuktuk.stadium.controller.dto.requestDto.court.CourtUpdateRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtCreateResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtDeleteResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtReadResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtUpdateResponseDto;
import com.example.tuktuk.stadium.service.CourtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/courts")
@RequiredArgsConstructor
@Slf4j
public class CourtController {

  private final CourtService courtService;

  @GetMapping("/{courtId}")
  public CourtReadResponseDto getCourtById(@PathVariable(name = "courtId") long courtId) {
    return courtService.findByCourtId(courtId);
  }

  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public CourtCreateResponseDto createCourt(
      @RequestPart("courtCreateRequest") CourtCreateRequestDto request,
      @RequestPart(value = "images", required = false) List<MultipartFile> images) {
    return courtService.saveCourt(request, images);
  }

  @PatchMapping(value = "/{courtId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public CourtUpdateResponseDto updateCourt(@PathVariable("courtId") long courtId,
      @RequestPart(value = "courtUpdateRequest", required = false) CourtUpdateRequestDto request,
      @RequestPart(value = "images", required = false) List<MultipartFile> images) {

    if (request == null && images == null) {
      throw new RuntimeException("잘못된 수정 요청입니다.");
    }

    return courtService.updateCourt(courtId, request, images);
  }

  @DeleteMapping(value = "/{courtId}")
  public CourtDeleteResponseDto deleteCourt(@PathVariable(name = "courtId") long courtId) {
    return courtService.deleteCourt(courtId);
  }
}
