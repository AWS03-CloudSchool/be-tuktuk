package com.example.tuktuk.stadium.service;

import com.example.tuktuk.stadium.controller.dto.requestDto.StadiumCreateRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.StadiumCreateResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.StadiumReadResponseDto;
import com.example.tuktuk.stadium.domain.stadium.Stadium;
import com.example.tuktuk.stadium.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class StadiumService {
    @Autowired
    private final StadiumRepository stadiumRepository;

    @Transactional(readOnly = true)
    public StadiumReadResponseDto findByStadiumId(Long id) {
        Stadium stadium = stadiumRepository.findById(id).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        return StadiumReadResponseDto.of(stadium);
    }

    @Transactional
    public StadiumCreateResponseDto saveStadium(StadiumCreateRequestDto request) {
        Stadium savedStadium = stadiumRepository.save(request.toEntity());
        return StadiumCreateResponseDto.of(savedStadium);
    }
}
