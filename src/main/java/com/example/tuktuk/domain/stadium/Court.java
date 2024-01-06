package com.example.tuktuk.domain.stadium;

import lombok.Getter;

import java.util.List;

@Getter
public class Court {

    String Name;
    CourtType courtType;
    int hourlyRentFee;
    List<String> images;  // 이미지 데이터를 바이트 배열로 저장

    public int getMinParticipants() {
        return courtType.getMinParticipants();
    }

    public int getMaxParticipants() {
        return courtType.getMaxParticipants();
    }
}
