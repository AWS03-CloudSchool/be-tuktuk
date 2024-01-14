package com.example.tuktuk.domain.courttimeslot;

import com.example.tuktuk.domain.global.Money;
import com.example.tuktuk.domain.stadium.CourtId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "court_time_slot")
public class CourtTimeSlot {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CourtId courtId;

    @Embedded
    private Time time;

    @Enumerated
    @Column(name = "type", nullable = false)
    private Type type;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "participants",
            joinColumns = @JoinColumn(name = "id"))
    @OrderColumn(name = "participant_idx")
    private List<Participant> participants;

    @Enumerated
    @Column(name = "reservation_status", nullable = false)
    private ReservationStatus reservationStatus;

    //비즈니스 로직으로 계산해서 넣어야 하는 필드
    @Embedded
    private Money matchFee;

}
