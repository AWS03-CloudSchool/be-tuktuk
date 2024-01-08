package com.example.tuktuk.domain.slice.gamematch;

import com.example.tuktuk.domain.slice.Slice;
import lombok.Getter;

import java.util.List;

@Getter
public class Game extends Slice {

    private GameStatus gameStatus;
    private List<Participant> participants;
    private int currentParticipants;


}
