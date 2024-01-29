package com.example.tuktuk.schedule.controller;

import com.example.tuktuk.schedule.controller.dto.requestDto.ScheduleCreateReqDto;
import com.example.tuktuk.schedule.controller.dto.responseDto.ScheduleCreateResDto;
import com.example.tuktuk.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
@Slf4j
public class ScheduleController {

    private final ScheduleService courtTimeSlotService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ScheduleCreateResDto createCourtTimeSlot(@RequestBody ScheduleCreateReqDto requestDto) {
        return courtTimeSlotService.saveCourtTimeSlot(requestDto);
    }
}
