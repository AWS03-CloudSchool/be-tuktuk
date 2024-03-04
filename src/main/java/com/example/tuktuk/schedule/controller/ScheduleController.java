package com.example.tuktuk.schedule.controller;

import com.example.tuktuk.schedule.controller.dto.requestDto.ScheduleCreateReqDto;
import com.example.tuktuk.schedule.controller.dto.requestDto.ScheduleUpdateReqDto;
import com.example.tuktuk.schedule.controller.dto.responseDto.*;
import com.example.tuktuk.schedule.service.ScheduleService;
import com.example.tuktuk.security.SecurityContextHolderUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
@Slf4j
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping(value = "/{scheduleId}")
    public ScheduleReadResponseDto findByScheduleId(@PathVariable(name = "scheduleId") long scheduleId) {
        return scheduleService.findByScheduleId(scheduleId);
    }

    @GetMapping("/search")
    public List<ScheduleSimpleReadResDto> findByProvince(
            @RequestParam(name = "province") String province,
            @RequestParam(name = "date") LocalDate date){
        return scheduleService.findByProvince(province, date);
    }

    @Secured("FIELD_OWNER")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ScheduleCreateResDto createSchedule(@RequestBody ScheduleCreateReqDto requestDto) {
        return scheduleService.saveSchedule(requestDto);
    }

    @Secured("FIELD_OWNER")
    @PatchMapping(value = "/{scheduleId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ScheduleUpdateResDto updateSchedule(@PathVariable(name = "scheduleId") long scheduleId,
                                               @RequestBody ScheduleUpdateReqDto requestDto) {
        return scheduleService.updateSchedule(scheduleId, requestDto);
    }

    @Secured("FIELD_OWNER")
    @DeleteMapping(value = "/{scheduleId}")
    public ScheduleDeleteResDto deleteSchedule(@PathVariable(name = "scheduleId") long scheduleId) {
        return scheduleService.deleteSchedule(scheduleId);
    }

    @Secured("FIELD_OWNER")
    @GetMapping
    public List<ScheduleReadResponseDto> findAllScheduleByOwner(){
        return scheduleService.findAllByOwnerId();
    }
}
