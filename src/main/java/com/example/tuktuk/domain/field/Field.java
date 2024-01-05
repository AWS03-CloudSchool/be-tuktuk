package com.example.tuktuk.domain.field;

import com.example.tuktuk.domain.member.Member;

import java.util.List;

public class Field {

    String fieldName;
    Member owner;
    String location;//지번까지의 상세한 주소
    int hourlyRentFee;
    FieldType fieldType;
    String fieldInfo; //주차 여부, 찾아 오는 상세한 길 같은 구단 등록주가 상세히 입력하는 폼.
    List<byte[]> images;  // 이미지 데이터를 바이트 배열로 저장
}
