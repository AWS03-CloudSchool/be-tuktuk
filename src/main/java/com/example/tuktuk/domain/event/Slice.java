package com.example.tuktuk.domain.event;

import com.example.tuktuk.domain.court.Court;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public abstract class Slice {

    @EmbeddedId
    private SliceId sliceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "court_id",nullable = false)
    private Court court;

    @Embedded
    private Time time;

    @Enumerated
    @Column(name = "status", nullable = false)
    private SliceStatus sliceStatus;

    public int getMinParticipants() {
        return court.getMinParticipants();
    }

    public int getMaxParticipants() {
        return court.getMaxParticipants();
    }
}
