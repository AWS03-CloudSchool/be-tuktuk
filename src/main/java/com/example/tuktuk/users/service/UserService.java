package com.example.tuktuk.users.service;

import com.example.tuktuk.users.controller.dto.requestDto.UserCreateReqDto;
import com.example.tuktuk.users.controller.dto.responseDto.UserCreateResDto;
import com.example.tuktuk.users.controller.dto.responseDto.UserReadResDto;
import com.example.tuktuk.users.domain.Provider;
import com.example.tuktuk.users.domain.Residence;
import com.example.tuktuk.users.domain.Role;
import com.example.tuktuk.users.domain.User;
import com.example.tuktuk.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserReadResDto findByUserId(final String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("잘못된 접근입니다."));
        return UserReadResDto.from(user);
    }

    @Transactional
    public UserCreateResDto saveUser(UserCreateReqDto request) {

        User user = User.builder()
                .id(request.getId())
                .email(request.getEmail())
                .nickName(request.getNickName())
                .gender(request.isGender())
                .telNo(request.getTelNo())
                .createdAt(LocalDateTime.now())
                .residence(Residence.of(request.getResidenceReqDto()))
                .roles(Collections.singletonList(Role.USER))
                .provider(Provider.valueOf(request.getProvider()))
                .build();

        User savedUser = userRepository.save(user);
        return UserCreateResDto.from(savedUser);
    }

}
