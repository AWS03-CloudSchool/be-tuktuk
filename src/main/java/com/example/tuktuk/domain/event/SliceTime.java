package com.example.tuktuk.domain.event;

import com.example.tuktuk.domain.court.Court;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public abstract class SliceTime {

    private final Court court;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final SliceTimeStatus sliceTimeStatus;


    public int getMinParticipants(){
        return court.getMinParticipants();
    }

    public int getMaxParticipants(){
        return court.getMaxParticipants();
    }
}
