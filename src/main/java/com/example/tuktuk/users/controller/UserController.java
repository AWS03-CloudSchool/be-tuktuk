package com.example.tuktuk.users.controller;

import com.example.tuktuk.users.controller.dto.requestDto.UserCreateReqDto;
import com.example.tuktuk.users.controller.dto.responseDto.UserCreateResDto;
import com.example.tuktuk.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserCreateResDto createUser(@RequestBody UserCreateReqDto request) {
        return userService.saveUser(request);
    }

}