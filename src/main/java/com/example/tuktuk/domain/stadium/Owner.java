package com.example.tuktuk.domain.stadium;

import com.example.tuktuk.domain.member.MemberId;
import jakarta.persistence.*;

@Embeddable
public class Owner {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "owner_id"))
    )
    private MemberId memberId;
}
