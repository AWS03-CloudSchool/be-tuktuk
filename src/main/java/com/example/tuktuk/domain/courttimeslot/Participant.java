package com.example.tuktuk.domain.courttimeslot;

import com.example.tuktuk.domain.user.UserId;
import jakarta.persistence.*;

@Embeddable
public class Participant {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "participant_id"))
    )
    private UserId userId;
}