package com.example.tuktuk.domain.global;

import com.example.tuktuk.domain.stadium.Court;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class DailySchedule {
    //에플리케이션이 최초로 시작할 때, 20일 어치를 한꺼번에 생성하고,
    //자정마다 20일 뒤의 DailySchedule을 하나씩 미리 만들어 놓기

    private final LocalDate localDate;
    private final Court court;
    private final List<SliceTime> available;


    //구단주가 10시 ~ 16시를 등록해 놓는 상황
    // list에 3개의 뭔가가
    // 14~16시 구장빌릴 수 있음
    //18시~20시 list에 없음.

}
