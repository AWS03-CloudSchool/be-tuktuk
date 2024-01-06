package com.example.tuktuk.domain.borrow;


import com.example.tuktuk.domain.global.SliceTime;
import com.example.tuktuk.domain.global.SliceTimeStatus;
import com.example.tuktuk.domain.stadium.Court;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class Borrow extends SliceTime {

    private Court court;

    private BorrowStatus bookStatus;

    public Borrow(LocalTime startTime, LocalTime endTime, SliceTimeStatus sliceTimeStatus) {
        super(startTime, endTime, sliceTimeStatus);
    }
}
