package com.example.tuktuk.stadium.service;

import com.example.tuktuk.stadium.controller.dto.requestDto.StadiumRegistrationRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.SimpleStadiumResponseDto;
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
    public SimpleStadiumResponseDto findByStadiumId(Long id) {
        Stadium stadium = stadiumRepository.findById(id).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        return SimpleStadiumResponseDto.of(stadium);
    }

    @Transactional
    public void saveStadium(StadiumRegistrationRequestDto request){
        stadiumRepository.save(request.toEntity());
    }
}