package com.example.tuktuk.stadium.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courts")
@RequiredArgsConstructor
@Slf4j
public class CourtController {
  @GetMapping("/{courtId}")
  public void getCourtById(){

  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void createCourt(){

  }

  @PatchMapping(value = "/{stadiumId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateCourt(){

  }

  @DeleteMapping("/{stadiumId}")
  public void deleteCourt(){

  }
}
