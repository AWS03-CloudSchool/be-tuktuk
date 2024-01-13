package com.example.tuktuk.domain.user;


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
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Embedded
    private Password password;

    @Column(name = "nick_name", nullable = false, length = 16)
    private String nickName;

    @Column(name = "profile_birth", nullable = false, length = 16)
    private String profileBirth;

    @Column(name = "gender", nullable = false, length = 3)
    private String gender;

    @Column(name = "tel_no", nullable = false, length = 36)
    private String telNo;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Embedded
    private Residence residence;

    @Enumerated
    @Column(name = "role", nullable = false)
    private Role role;

    @Comment("This column is social login provider (kakao, google, naver)")
    @Column(name = "provider", nullable = false, length = 36)
    private String provider;
}
