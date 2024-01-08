package com.example.tuktuk.domain.event.borrow;


import com.example.tuktuk.domain.event.Slice;
import lombok.Getter;


@Getter
public class Borrow extends Slice {

    private Borrower borrower;

    private BorrowStatus bookStatus;


}
