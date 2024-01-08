package com.example.tuktuk.domain.reservation;

import com.example.tuktuk.domain.global.Money;
import com.example.tuktuk.domain.slice.SliceId;
import com.example.tuktuk.domain.member.MemberId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private MemberId memberId;

    @Embedded
    private SliceId sliceId;

    @Embedded
    private Money fee;

    //할인 내역

    //결게 금액 같은 정보 들어감
}
