package com.example.tuktuk.stadium.service;

import com.example.tuktuk.stadium.controller.dto.requestDto.stadium.StadiumCreateRequestDto;
import com.example.tuktuk.stadium.controller.dto.requestDto.stadium.StadiumUpdateRequestDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumCreateResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumDeleteResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumReadResponseDto;
import com.example.tuktuk.stadium.controller.dto.responseDto.stadium.StadiumUpdateResponseDto;
import com.example.tuktuk.stadium.domain.Location;
import com.example.tuktuk.stadium.domain.stadium.Stadium;
import com.example.tuktuk.stadium.repository.StadiumRepository;
import com.example.tuktuk.users.domain.UserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class StadiumService {
    @Autowired
    private final StadiumRepository stadiumRepository;

    @Transactional(readOnly = true)
    public StadiumReadResponseDto findByStadiumId(final long stadiumId) {
        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        return StadiumReadResponseDto.from(stadium);
    }

    @Transactional(readOnly = true)
    public List<StadiumReadResponseDto> findByOwnerId(final String ownerId) {
        List<Stadium> stadiums = stadiumRepository.findByOwnerId(ownerId);
        return stadiums.stream()
                .map(StadiumReadResponseDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public StadiumCreateResponseDto saveStadium(String ownerId, StadiumCreateRequestDto request) {

        Stadium stadium = Stadium.builder()
                .name(request.getName())
                .ownerId(new UserId(ownerId))
                .location(Location.of(request.getLocationReqDto()))
                .specificInfo(request.getSpecificInfo())
                .build();

        Stadium savedStadium = stadiumRepository.save(stadium);
        return StadiumCreateResponseDto.from(savedStadium);
    }

    @Transactional
    public StadiumUpdateResponseDto updateStadium(final String ownerId, final long stadiumId, StadiumUpdateRequestDto request) {

        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        if (!stadium.getOwnerId().getUserId().equals(ownerId)) {
            throw new IllegalStateException("수정할 권한이 없습니다.");
        }
        stadium.update(request);
        Stadium updatedStadium = stadiumRepository.save(stadium);
        return StadiumUpdateResponseDto.from(updatedStadium);
    }

    @Transactional
    public StadiumDeleteResponseDto deleteStadium(final long stadiumId) {
        Stadium stadium = stadiumRepository.findById(stadiumId).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        stadiumRepository.delete(stadium);

        return StadiumDeleteResponseDto.from(stadium);
    }
}
