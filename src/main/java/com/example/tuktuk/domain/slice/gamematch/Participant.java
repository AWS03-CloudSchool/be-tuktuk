package com.example.tuktuk.domain.slice.gamematch;

import com.example.tuktuk.domain.member.MemberId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;

public class Participant {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "participant_id"))
    )
    private MemberId memberId;
}
