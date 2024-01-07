package com.example.tuktuk.domain.member;


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
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Comment("이메일")
    @Column(name = "username", nullable = false, columnDefinition = "varchar(255)")
    private String username;

    @Column(name = "nick_name", nullable = false, columnDefinition = "varchar(16)")
    private String nickName;

    @Column(name = "profile_birth", nullable = false, columnDefinition = "varchar(16)")
    private String profileBirth;

    @Column(name = "gender", nullable = false, columnDefinition = "varchar(3)")
    private String gender;

    @Column(name = "tel_no", nullable = false, columnDefinition = "varchar(36)")
    private String telNo;

    @Column(name = "created_at", nullable = false, columnDefinition = "datetime")
    private LocalDateTime createdAt;

    @Embedded
    private Residence residence; //경기도 의왕시 내손동, 서울 특별시 중랑구

    @Enumerated
    @Column(name = "role", nullable = false)
    private Role role;


    @Comment("소셜 로그인시 갱신됨 (네이버, 카카오, 구글 중 하나)")
    @Column(name = "provider", nullable = false, columnDefinition = "varchar(36)")
    private String provider;


}
