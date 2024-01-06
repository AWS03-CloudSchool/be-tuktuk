package com.example.tuktuk.domain.gamematch;

import com.example.tuktuk.domain.global.SliceTime;
import com.example.tuktuk.domain.global.SliceTimeStatus;
import com.example.tuktuk.domain.stadium.Court;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class Game extends SliceTime {

    private Court court;
    private GameStatus gameStatus;
    private int currentParticipants;

    public Game(LocalTime startTime, LocalTime endTime, SliceTimeStatus sliceTimeStatus) {
        super(startTime, endTime, sliceTimeStatus);
    }

    public void updateGameStatus() {
        if (currentParticipants < court.getMinParticipants()) {
            this.gameStatus = GameStatus.NOT_ENOUGH_PLAYERS;
            return;
        }

        if (currentParticipants < court.getMaxParticipants()) {
            this.gameStatus = GameStatus.ENOUGH_PLAYERS;
            return;
        }

        this.gameStatus = GameStatus.FULL_CAPACITY;

    }

}
