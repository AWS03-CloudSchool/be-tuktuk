package com.example.tuktuk.domain.event.borrow;

import com.example.tuktuk.domain.member.MemberId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;

public class Borrower {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "borrower_id"))
    )
    private MemberId memberId;
}
