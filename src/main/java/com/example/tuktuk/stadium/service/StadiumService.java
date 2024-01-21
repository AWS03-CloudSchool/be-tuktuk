package com.example.tuktuk.stadium.service;

import com.example.tuktuk.stadium.controller.dto.requestDto.stadium.StadiumCreateRequestDto;
import com.example.tuktuk.stadium.controller.dto.requestDto.stadium.StadiumUpdateRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumCreateResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumReadResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumUpdateResponseDto;
import com.example.tuktuk.stadium.domain.Location;
import com.example.tuktuk.stadium.domain.stadium.Stadium;
import com.example.tuktuk.stadium.repository.StadiumRepository;
import com.example.tuktuk.user.domain.UserId;
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
    public StadiumReadResponseDto findByStadiumId(long stadiumId) {
        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        return StadiumReadResponseDto.from(stadium);
    }

    @Transactional
    public StadiumCreateResponseDto saveStadium(StadiumCreateRequestDto request) {

        Stadium stadium = Stadium.builder()
                .name(request.getName())
                .ownerId(new UserId(1L))
                .location(Location.of(request.getLocationReqDto()))
                .specificInfo(request.getSpecificInfo())
                .build();

        Stadium savedStadium = stadiumRepository.save(stadium);
        return StadiumCreateResponseDto.from(savedStadium);
    }

    @Transactional
    public StadiumUpdateResponseDto updateStadium(long stadiumId, StadiumUpdateRequestDto request) {

        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        stadium.update(request);
        Stadium updatedStadium = stadiumRepository.save(stadium);
        return StadiumUpdateResponseDto.from(updatedStadium);
    }

    @Transactional
    public void deleteStadium(long stadiumId) {

        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        stadiumRepository.delete(stadium);
    }
}
