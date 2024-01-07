package com.example.tuktuk.domain.gamematch;

import com.example.tuktuk.domain.global.SliceTime;
import com.example.tuktuk.domain.global.SliceTimeStatus;
import com.example.tuktuk.domain.stadium.Court;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class Game extends SliceTime {

    private GameStatus gameStatus;
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
