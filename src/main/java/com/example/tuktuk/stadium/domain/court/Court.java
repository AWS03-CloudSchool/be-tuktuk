package com.example.tuktuk.stadium.domain.court;

import com.example.tuktuk.stadium.domain.stadium.Stadium;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courts")
public class Court {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "stadium_id", nullable = false)
    private Stadium stadium;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CourtType courtType;

    @Column(name = "hourly_rate", nullable = false)
    private int hourlyRentFee;

    @ElementCollection
    @CollectionTable(name = "court_images", joinColumns = @JoinColumn(name = "court_id"))
    @Column(name = "image_path")
    private List<String> images = new ArrayList<>();

    public int getMinParticipants() {
        return courtType.getMinParticipants();
    }

    public int getMaxParticipants() {
        return courtType.getMaxParticipants();
    }
}
