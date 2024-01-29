package com.example.tuktuk.courttimeslot.service;


import com.example.tuktuk.courttimeslot.controller.dto.requestDto.CourtTimeSlotCreateReqDto;
import com.example.tuktuk.courttimeslot.controller.dto.responseDto.CourtTimeSlotCreateResDto;
import com.example.tuktuk.courttimeslot.domain.CourtTimeSlot;
import com.example.tuktuk.courttimeslot.domain.MatchRegularFeeManager;
import com.example.tuktuk.courttimeslot.domain.Time;
import com.example.tuktuk.courttimeslot.domain.Type;
import com.example.tuktuk.courttimeslot.repository.CourtTimeSlotRepository;
import com.example.tuktuk.courttimeslot.util.TimeInfoToDomainConverter;
import com.example.tuktuk.global.Money;
import com.example.tuktuk.global.Province;
import com.example.tuktuk.stadium.domain.court.Court;
import com.example.tuktuk.stadium.domain.court.CourtId;
import com.example.tuktuk.stadium.domain.stadium.Stadium;
import com.example.tuktuk.stadium.repository.CourtRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourtTimeSlotService {

    private final CourtTimeSlotRepository courtTimeSlotRepository;

    private final CourtRepository courtRepository;

    @Transactional
    public CourtTimeSlotCreateResDto saveCourtTimeSlot(CourtTimeSlotCreateReqDto requestDto) {

        long courtId = requestDto.getCourtId();
        Court court = courtRepository.findById(courtId).orElseThrow(() -> new IllegalStateException("잘못된 코트 참조입니다."));
        Stadium stadium = court.getStadium();
        Province province = stadium.getLocation().getProvince();
        //stadium까지 조회하는 문제가 생김..

        int matchRegularFee = MatchRegularFeeManager.calculateRegularFee(province, requestDto.getPlayDate());

        Time time = TimeInfoToDomainConverter.convertTimeInfoToDomain(requestDto.getPlayDate(),
                requestDto.getStartTime(), requestDto.getEndTime());

        CourtTimeSlot courtTimeSlot = CourtTimeSlot.builder()
                .courtId(new CourtId(courtId))
                .time(time)
                .type(Type.valueOf(requestDto.getType()))
                .matchRegularFee(new Money(matchRegularFee))
                .build();

        CourtTimeSlot savedCourtTimeSlot = courtTimeSlotRepository.save(courtTimeSlot);
        return CourtTimeSlotCreateResDto.from(savedCourtTimeSlot);
    }
}
