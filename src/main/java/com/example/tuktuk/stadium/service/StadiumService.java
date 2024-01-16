package com.example.tuktuk.stadium.service;

import com.example.tuktuk.stadium.controller.dto.requestDto.StadiumCreateRequestDto;
import com.example.tuktuk.stadium.controller.dto.requestDto.StadiumUpdateRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.StadiumCreateResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.StadiumReadResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.StadiumUpdateResponseDto;
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
    public StadiumReadResponseDto findByStadiumId(Long id) {
        Stadium stadium = stadiumRepository.findById(id).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        return StadiumReadResponseDto.from(stadium);
    }

    @Transactional
    public StadiumCreateResponseDto saveStadium(StadiumCreateRequestDto request) {
        //security로 권한 확인 후
        //Long userId = SecurityContextHolderUtil.getUserId();
        //권한 없으면 에러
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
    public StadiumUpdateResponseDto updateStadium(Long stadiumId, StadiumUpdateRequestDto request) {
        //security로 권한 확인 후
        //Long userId = SecurityContextHolderUtil.getUserId();
        //권한 없으면 에러

        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        stadium.update(request);
        Stadium updatedStadium = stadiumRepository.save(stadium);
        return StadiumUpdateResponseDto.from(updatedStadium);
    }

    @Transactional
    public void deleteStadium(Long stadiumId) {
        //security로 권한 확인 후
        //Long userId = SecurityContextHolderUtil.getUserId();
        //권한 없으면 에러

        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        stadiumRepository.delete(stadium);
    }


}
