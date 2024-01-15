package com.example.tuktuk.reservation;

import com.example.tuktuk.global.Money;
import com.example.tuktuk.courttimeslot.CourtTimeSlotId;
import com.example.tuktuk.user.domain.UserId;
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
