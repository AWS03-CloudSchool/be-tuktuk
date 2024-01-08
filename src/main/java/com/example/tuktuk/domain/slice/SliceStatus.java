package com.example.tuktuk.domain.slice;

public enum SliceStatus {

    ACTIVATE,
    INACTIVATE;

    //sliceTime이 borrow, game 중 어느 타입일 수 있다.
    //어떤 거인지와 관계없이 예약이 다 차면, INACTIVATE로 바꿔 부모클래스에서 timeSlice의 상태를 관리하는게 좋을 듯해서 만들었엉
    //읽었으면 지워도 돼
}
