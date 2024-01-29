package com.example.tuktuk.schedule.service;


import com.example.tuktuk.schedule.controller.dto.requestDto.ScheduleCreateReqDto;
import com.example.tuktuk.schedule.controller.dto.requestDto.ScheduleUpdateReqDto;
import com.example.tuktuk.schedule.controller.dto.responseDto.ScheduleCreateResDto;
import com.example.tuktuk.schedule.controller.dto.responseDto.ScheduleUpdateResDto;
import com.example.tuktuk.schedule.domain.*;
import com.example.tuktuk.schedule.repository.ScheduleRepository;
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


import java.time.LocalDate;
import java.time.LocalTime;

import static com.example.tuktuk.schedule.domain.ReservationStatus.AVAILABLE;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final CourtRepository courtRepository;

    @Transactional
    public ScheduleCreateResDto saveSchedule(ScheduleCreateReqDto requestDto) {

        long courtId = requestDto.getCourtId();
        Court court = courtRepository.findById(courtId).orElseThrow(() -> new IllegalStateException("잘못된 코트 참조입니다."));
        Stadium stadium = court.getStadium();
        Province province = stadium.getLocation().getProvince();
        //stadium까지 조회하는 문제가 생김..

        Time time = Time.builder()
                .playDate(LocalDate.parse(requestDto.getPlayDate()))
                .startTime(LocalTime.parse(requestDto.getStartTime()))
                .endTime(LocalTime.parse(requestDto.getEndTime()))
                .build();

        int matchRegularFee = MatchRegularFeeManager.calculateRegularFee(province, time.getPlayDate());

        Schedule courtTimeSlot = Schedule.builder()
                .courtId(new CourtId(courtId))
                .time(time)
                .type(Type.valueOf(requestDto.getType()))
                .reservationStatus(AVAILABLE)
                .matchRegularFee(new Money(matchRegularFee))
                .build();

        Schedule savedCourtTimeSlot = scheduleRepository.save(courtTimeSlot);
        return ScheduleCreateResDto.from(savedCourtTimeSlot);
    }

    @Transactional
    public ScheduleUpdateResDto updateSchedule(long scheduleId, ScheduleUpdateReqDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new IllegalStateException("Schedule을 찾을 수 없습니다."));
        schedule.update(requestDto);
        Schedule updatedSchedule = scheduleRepository.save(schedule);
        return ScheduleUpdateResDto.from(updatedSchedule);
    }
}
