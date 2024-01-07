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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id",nullable = false)
    private Stadium stadium;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(64)")
    private String Name;

    @Enumerated
    @Column(name = "type",nullable = false)
    private CourtType courtType;

    @Column(name = "hourly_rate",nullable = false)
    private int hourlyRentFee;

//    List<String> images;  // 이미지 데이터를 바이트 배열로 저장

    /**
     * image 3장씩 저장해야 하는데, s3 ?? 애는 어케 해야할지 정해야 함
     *
     */

    public int getMinParticipants() {
        return courtType.getMinParticipants();
    }

    public int getMaxParticipants() {
        return courtType.getMaxParticipants();
    }
}
