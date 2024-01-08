package com.example.tuktuk.domain.slice;

import com.example.tuktuk.domain.stadium.CourtId;
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
@Table(name = "slice")
public abstract class Slice {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CourtId courtId;

    @Embedded
    private Time time;

    @Enumerated
    @Column(name = "status", nullable = false)
    private SliceStatus sliceStatus;

}
