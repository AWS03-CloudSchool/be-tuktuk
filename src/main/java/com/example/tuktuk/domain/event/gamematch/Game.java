package com.example.tuktuk.domain.event.gamematch;

import com.example.tuktuk.domain.event.Slice;
import lombok.Getter;

import java.util.List;

@Getter
public class Game extends Slice {

    private GameStatus gameStatus;
    private List<Participant> participants;
    private int currentParticipants;


}
