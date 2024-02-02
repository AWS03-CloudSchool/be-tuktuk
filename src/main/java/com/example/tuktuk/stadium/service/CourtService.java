package com.example.tuktuk.stadium.service;

import com.example.tuktuk.stadium.controller.dto.requestDto.court.CourtCreateRequestDto;
import com.example.tuktuk.stadium.controller.dto.requestDto.court.CourtUpdateRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtCreateResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtDeleteResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtReadResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtUpdateResponseDto;
import com.example.tuktuk.stadium.domain.court.Court;
import com.example.tuktuk.stadium.domain.court.CourtImage;
import com.example.tuktuk.stadium.domain.court.CourtType;
import com.example.tuktuk.stadium.domain.stadium.Stadium;
import com.example.tuktuk.stadium.repository.CourtImageRepository;
import com.example.tuktuk.stadium.repository.CourtRepository;
import com.example.tuktuk.stadium.repository.StadiumRepository;
import com.example.tuktuk.stadium.util.image.ObjectStorageFunction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourtService {

  @Autowired
  private CourtRepository courtRepository;

  @Autowired
  ObjectStorageFunction storageManager;

  @Autowired
  private StadiumRepository stadiumRepository;

  @Autowired
  CourtImageRepository courtImageRepository;

  @Transactional(readOnly = true)
  public CourtReadResponseDto findByCourtId(Long courtId) {
    return CourtReadResponseDto.from(courtRepository.findById(courtId).get());
  }


  @Transactional(readOnly = true)
  public List<CourtReadResponseDto> findByStadiumId(Long stadiumId) {
    List<Court> courts = courtRepository.findByStadiumId(stadiumId);

    return courts.stream()
        .map(CourtReadResponseDto::from)
        .toList();
  }

  @Transactional
  public CourtCreateResponseDto saveCourt(CourtCreateRequestDto request,
      List<MultipartFile> images) {
    Court savedCourt;

    Stadium parentStadium = stadiumRepository.findById(request.getStadiumId())
        .orElseThrow(() -> new RuntimeException("찾을 수 없는 경기장입니다."));

    if (images == null || images.isEmpty()) {
      Court court = Court.builder()
          .stadium(parentStadium)
          .name(request.getName())
          .courtType(CourtType.valueOf(request.getCourtType()))
          .images(new ArrayList<>())
          .hourlyRentFee(request.getHourlyRentFee())
          .build();

      savedCourt = courtRepository.save(court);
    } else {
      Court court = Court.builder()
          .stadium(parentStadium)
          .name(request.getName())
          .courtType(CourtType.valueOf(request.getCourtType()))
          .images(new ArrayList<>())
          .hourlyRentFee(request.getHourlyRentFee())
          .build();

      savedCourt = courtRepository.save(court);

      List<CourtImage> savedImages = insertCourtImages(savedCourt, images);
      savedCourt.setImages(savedImages);
    }

    return CourtCreateResponseDto.from(savedCourt);
  }

  @Transactional
  private List<CourtImage> insertCourtImages(Court court, List<MultipartFile> images) {
    List<CourtImage> courtImages = images.stream().map(image -> {
          String savedObjectName = storageManager.putObject(image);
          String objectPath = storageManager.getObject(savedObjectName);

          return CourtImage.builder()
              .court(court)
              .imagePath(objectPath)
              .build();
        }
    ).toList();

    List<CourtImage> savedCourtImages = courtImageRepository.saveAll(courtImages);

    return savedCourtImages;
  }

  @Transactional
  public CourtUpdateResponseDto updateCourt(Long courtId,
      CourtUpdateRequestDto request,
      List<MultipartFile> images
  ) {
    Court oldCourt = courtRepository.findById(courtId)
        .orElseThrow(() -> new RuntimeException("찾을 수 없는 경기장입니다."));

    /*
      To do : 이미지 수정 기능 구현
    */

    Court newCourt = Court.builder()
        .id(oldCourt.getId())
        .name(request.getName())
        .courtType(CourtType.valueOf(request.getCourtType()))
        .hourlyRentFee(request.getHourlyRentFee())
        .stadium(oldCourt.getStadium())
        .images(oldCourt.getImages())
        .build();

    Court updatedCourt = courtRepository.save(newCourt);

    return CourtUpdateResponseDto.from(updatedCourt);
  }

  @Transactional
  public CourtDeleteResponseDto deleteCourt(long courtId) {

    Court court = courtRepository.findById(courtId)
        .orElseThrow(() -> new RuntimeException("찾을 수 없는 코트입니다."));

    courtRepository.delete(court);

    return CourtDeleteResponseDto.from(court);
  }
}
