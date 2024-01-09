package com.example.tuktuk.domain.stadium;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "court")
public class Court {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stadium_id",nullable = false)
    private Stadium stadium;

    @Column(name = "name", nullable = false, length = 64)
    private String Name;

    @Enumerated
    @Column(name = "type", nullable = false)
    private CourtType courtType;

    @Column(name = "hourly_rate", nullable = false)
    private int hourlyRentFee;

    /*
        Court의 이미지를 제공하기 위해 S3에 저장된 Court의 엔드포인트 URL을 저장

        List<String> images;
    */
    public int getMinParticipants() {
        return courtType.getMinParticipants();
    }

    public int getMaxParticipants() {
        return courtType.getMaxParticipants();
    }
}
