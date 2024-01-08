package com.example.tuktuk.domain.global;

import com.example.tuktuk.domain.event.SliceId;
import com.example.tuktuk.domain.member.MemberId;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @EmbeddedId
    private ReservationId reservationId;

    @Embedded
    private MemberId memberId;

    @Embedded
    private SliceId sliceId;

    @Embedded
    private Money fee;

    //할인 내역

    //결게 금액 같은 정보 들어감
}
