package com.example.tuktuk.domain.event;

import com.example.tuktuk.domain.court.CourtId;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public abstract class Slice {

    @EmbeddedId
    private SliceId sliceId;

    @Embedded
    private CourtId courtId;

    @Embedded
    private Time time;

    @Enumerated
    @Column(name = "status", nullable = false)
    private SliceStatus sliceStatus;

}
