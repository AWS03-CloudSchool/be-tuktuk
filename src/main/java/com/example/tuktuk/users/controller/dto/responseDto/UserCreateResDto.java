package com.example.tuktuk.users.controller.dto.responseDto;

import com.example.tuktuk.users.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserCreateResDto {

    private final String nickName;

    private final String email;

    private final String gender;

    private final String telNo;

    private final ResidenceResDto residenceResDto;

    private final String role;

    private final String provider;

    public static UserCreateResDto from(User user) {
        return UserCreateResDto.builder()
                .nickName(user.getNickName())
                .email(user.getEmail())
                .gender(user.getGender())
                .telNo(user.getTelNo())
                .residenceResDto(ResidenceResDto.from(user.getResidence()))
                .role(user.getRole().name())
                .provider(user.getProvider())
                .build();
    }

}
