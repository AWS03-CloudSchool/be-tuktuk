package com.example.tuktuk.domain.event;

import com.example.tuktuk.domain.global.Money;
import com.example.tuktuk.domain.member.Member;
import com.example.tuktuk.domain.member.MemberId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Reservation {

    private final MemberId member;
    private final SliceId sliceId;
    private final Money fee;

    //할인 내역

    //결게 금액 같은 정보 들어감


}
