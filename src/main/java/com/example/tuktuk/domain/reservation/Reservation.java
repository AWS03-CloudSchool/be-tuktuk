package com.example.tuktuk.domain.reservation;

import com.example.tuktuk.domain.global.Money;
import com.example.tuktuk.domain.courttimeslot.CourtTimeSlotId;
import com.example.tuktuk.domain.user.UserId;
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
    private UserId memberId;

    @Embedded
    private CourtTimeSlotId sliceId;

    @Embedded
    private Money fee;
}
