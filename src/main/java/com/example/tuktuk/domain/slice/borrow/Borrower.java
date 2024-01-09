package com.example.tuktuk.domain.slice.borrow;

import com.example.tuktuk.domain.user.UserId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;

public class Borrower {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "borrower_id"))
    )
    private UserId userId;
}
