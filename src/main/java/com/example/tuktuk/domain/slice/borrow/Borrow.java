package com.example.tuktuk.domain.slice.borrow;


import com.example.tuktuk.domain.slice.Slice;
import lombok.Getter;


@Getter
public class Borrow extends Slice {

    private Borrower borrower;

    private BorrowStatus bookStatus;


}
