package com.example.tuktuk.courttimeslot.controller;

import com.example.tuktuk.courttimeslot.controller.dto.requestDto.CourtTimeSlotCreateReqDto;
import com.example.tuktuk.courttimeslot.controller.dto.responseDto.CourtTimeSlotCreateResDto;
import com.example.tuktuk.courttimeslot.service.CourtTimeSlotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courttimeslots")
@RequiredArgsConstructor
@Slf4j
public class CourtTimeSlotController {

    private final CourtTimeSlotService courtTimeSlotService;

    public CourtTimeSlotCreateResDto createCourtTimeSlot(@RequestBody CourtTimeSlotCreateReqDto requestDto) {

        return courtTimeSlotService.saveCourtTimeSlot(requestDto);
    }
}
