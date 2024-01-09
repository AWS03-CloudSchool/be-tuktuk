package com.example.tuktuk.domain.slice.gamematch;

import com.example.tuktuk.domain.slice.Slice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game")
public class Game {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "slice_id", nullable = false)
    private Slice slice;

    @Enumerated
    @Column(name = "status", nullable = false)
    private GameStatus gameStatus;

    @Column(name = "current_participants")
    private int currentParticipants;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "participant_line",
            joinColumns = @JoinColumn(name = "id"))
    @OrderColumn(name = "line_idx")
    private List<Participant> participants;
}
