package com.example.tuktuk.users.controller.dto.requestDto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateReqDto {

    private String id;

    private String email;

    private String nickName;

    private boolean gender;

    private String telNo;

    private ResidenceReqDto residenceReqDto;

    private String role;

    private String provider;
}
