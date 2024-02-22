package com.example.tuktuk.schedule.controller;

import com.example.tuktuk.global.Message;
import com.example.tuktuk.schedule.controller.dto.requestDto.ScheduleCreateReqDto;
import com.example.tuktuk.schedule.controller.dto.requestDto.ScheduleUpdateReqDto;
import com.example.tuktuk.schedule.controller.dto.responseDto.ScheduleCreateResDto;
import com.example.tuktuk.schedule.controller.dto.responseDto.ScheduleReadResponseDto;
import com.example.tuktuk.schedule.controller.dto.responseDto.ScheduleUpdateResDto;
import com.example.tuktuk.schedule.service.ScheduleService;
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
    public Message deleteSchedule(@PathVariable(name = "scheduleId") long scheduleId) {
        return scheduleService.deleteSchedule(scheduleId);
    }
}
