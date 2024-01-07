package com.example.tuktuk.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MemberId implements Serializable {

    @Column(name = "member_id")
    private long id;

    protected MemberId() {

    }
}
