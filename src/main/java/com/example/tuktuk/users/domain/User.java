package com.example.tuktuk.users.domain;


import com.example.tuktuk.global.Province;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "nick_name", nullable = false, length = 16)
    private String nickName;

    @Column(name = "gender", nullable = false)
    private boolean gender;

    @Column(name = "tel_no", nullable = false, length = 36)
    private String telNo;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Embedded
    private Residence residence;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider", length = 36)
    private Provider provider;
}