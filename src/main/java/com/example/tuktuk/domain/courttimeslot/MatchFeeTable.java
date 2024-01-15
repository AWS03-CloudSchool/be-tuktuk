package com.example.tuktuk.domain.courttimeslot;

import com.example.tuktuk.domain.global.DayType;
import com.example.tuktuk.domain.global.Province;

public enum MatchFeeTable {

    SEOUL_WEEKDAY_FEE(Province.SEOUL, DayType.WEEKDAY, 12000),
    SEOUL_WEEKEND_FEE(Province.SEOUL, DayType.WEEKEND, 13000),

    GYEONGGI_WEEKDAY_FEE(Province.GYEONGGI, DayType.WEEKDAY, 11000),
    GYEONGGI_WEEKEND_FEE(Province.GYEONGGI, DayType.WEEKEND, 12000);

    private Province province;
    private DayType dayType;
    private int regularFee;

    MatchFeeTable(Province province, DayType dayType, int regularFee) {
        this.province = province;
        this.dayType = dayType;
        this.regularFee = regularFee;
    }
}
