package com.example.tuktuk.domain.borrow;


import com.example.tuktuk.domain.global.SliceTime;
import com.example.tuktuk.domain.global.SliceTimeStatus;
import com.example.tuktuk.domain.stadium.Court;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class Borrow extends SliceTime {

    private BorrowStatus bookStatus;


    public Borrow(Court court, LocalTime startTime, LocalTime endTime, SliceTimeStatus sliceTimeStatus) {
        super(court, startTime, endTime, sliceTimeStatus);
    }
}
