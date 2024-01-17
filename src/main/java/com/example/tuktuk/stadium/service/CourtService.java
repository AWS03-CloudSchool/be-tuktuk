package com.example.tuktuk.stadium.service;

import com.example.tuktuk.stadium.controller.dto.responseDto.court.CourtReadResponseDto;
import com.example.tuktuk.stadium.domain.court.Court;
import com.example.tuktuk.stadium.repository.CourtRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourtService {
  @Autowired
  private CourtRepository courtRepository;

  @Transactional(readOnly = true)
  public CourtReadResponseDto findByCourtId(Long courtId){
    return CourtReadResponseDto.from(courtRepository.findById(courtId).get());
  }

  public void saveCourt(){

  }

  public void updateCourt(){

  }

  public void deleteCourt(){

  }
}
