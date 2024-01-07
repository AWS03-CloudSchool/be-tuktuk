package com.example.tuktuk.domain.event.borrow;


import com.example.tuktuk.domain.event.SliceTime;
import com.example.tuktuk.domain.event.SliceTimeStatus;
import com.example.tuktuk.domain.court.Court;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class Borrow extends SliceTime {

    private Borrower borrower;

    private BorrowStatus bookStatus;

    public Borrow(Court court, LocalTime startTime, LocalTime endTime, SliceTimeStatus sliceTimeStatus) {
        super(court, startTime, endTime, sliceTimeStatus);
    }
}
