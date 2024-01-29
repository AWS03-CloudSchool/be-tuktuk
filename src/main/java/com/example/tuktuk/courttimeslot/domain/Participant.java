package com.example.tuktuk.courttimeslot.domain;

import com.example.tuktuk.user.domain.UserId;
import jakarta.persistence.*;

@Embeddable
public class Participant {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "participant_id"))
    )
    private UserId userId;
}
