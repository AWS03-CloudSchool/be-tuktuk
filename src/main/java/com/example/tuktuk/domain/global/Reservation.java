package com.example.tuktuk.domain.global;

import com.example.tuktuk.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Reservation {

    private final Member member;
    private final SliceTime sliceTime;

    //할인 내역

    //결게 금액 같은 정보 들어감


}
