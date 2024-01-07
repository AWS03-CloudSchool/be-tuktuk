package com.example.tuktuk.domain.event.gamematch;

import com.example.tuktuk.domain.event.SliceTime;
import com.example.tuktuk.domain.event.SliceTimeStatus;
import com.example.tuktuk.domain.court.Court;
import lombok.Getter;

import java.time.LocalTime;
import java.util.List;

@Getter
public class Game extends SliceTime {

    private GameStatus gameStatus;
    private List<Participant> participants;
    private int currentParticipants;

    public Game(Court court, LocalTime startTime, LocalTime endTime, SliceTimeStatus sliceTimeStatus) {
        super(court, startTime, endTime, sliceTimeStatus);
    }


    public void updateGameStatus() {
        if (currentParticipants < super.getMinParticipants()) {
            this.gameStatus = GameStatus.NOT_ENOUGH_PLAYERS;
            return;
        }

        if (currentParticipants < super.getMaxParticipants()) {
            this.gameStatus = GameStatus.ENOUGH_PLAYERS;
            return;
        }

        this.gameStatus = GameStatus.FULL_CAPACITY;

    }

}
