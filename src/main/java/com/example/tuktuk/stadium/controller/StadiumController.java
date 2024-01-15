package com.example.tuktuk.stadium.controller;

import com.example.tuktuk.global.Message;
import com.example.tuktuk.stadium.controller.dto.responseDto.StadiumReadResponseDto;
import com.example.tuktuk.stadium.service.StadiumService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("stadium")
public class StadiumController {

    private final StadiumService stadiumService;

    @GetMapping("/{stadiumId}/info")
    public void showStadium(@PathVariable Long stadiumId, HttpServletResponse response) throws IOException {
        ObjectMapper om = new ObjectMapper();
        response.setContentType(MediaType.APPLICATION_JSON.toString());

        StadiumReadResponseDto responseDto = stadiumService.findByStadiumId(stadiumId);

        Message message = Message.builder()
                .data(responseDto)
                .status(HttpStatus.OK)
                .message("success")
                .build();
        om.writeValue(response.getOutputStream(), message);
    }
}
