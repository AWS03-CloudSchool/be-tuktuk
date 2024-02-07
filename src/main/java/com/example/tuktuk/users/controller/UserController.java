package com.example.tuktuk.users.controller;

import com.example.tuktuk.users.controller.dto.requestDto.UserCreateReqDto;
import com.example.tuktuk.users.controller.dto.responseDto.UserCreateResDto;
import com.example.tuktuk.users.controller.dto.responseDto.UserReadResDto;
import com.example.tuktuk.users.domain.Provider;
import com.example.tuktuk.users.service.LoginService;
import com.example.tuktuk.users.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    private final LoginService loginService;

    @GetMapping("/mypage")
    public UserReadResDto getMyProfile(HttpServletRequest request) {
        String userId = request.getHeader("tuktuk");

        return userService.findByUserId(userId);
    }

    @GetMapping("/login")
    public ResponseEntity<UserReadResDto> login(@RequestParam String code, HttpServletRequest request,
                                                HttpServletResponse response) {

        UserReadResDto userReadResDto = loginService.socialLogin(code, response);
        return new ResponseEntity<>(userReadResDto, HttpStatus.OK);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserCreateResDto createUser(@RequestBody UserCreateReqDto createReqDto, HttpServletRequest request) {
        String userId = (String) request.getAttribute("id");
        String email = (String) request.getAttribute("email");
        Provider provider = (Provider) request.getAttribute("provider");

        return userService.saveUser(userId, email, provider, createReqDto);
    }

}
