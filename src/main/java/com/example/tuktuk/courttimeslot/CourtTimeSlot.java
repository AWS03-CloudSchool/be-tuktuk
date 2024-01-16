package com.example.tuktuk.courttimeslot;

import com.example.tuktuk.global.Money;
import com.example.tuktuk.stadium.domain.court.CourtId;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "participants",
            joinColumns = @JoinColumn(name = "id"))
    @OrderColumn(name = "participant_idx")
    private List<Participant> participants;

    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status", nullable = false)
    private ReservationStatus reservationStatus;

    @Embedded
    private Money matchRegularFee;

}
