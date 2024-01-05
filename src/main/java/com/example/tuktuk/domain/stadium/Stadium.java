package com.example.tuktuk.domain.stadium;

import com.example.tuktuk.domain.member.Member;

import java.util.List;


public class Stadium {

    String Name;
    Member owner;
    String location;//지번까지의 상세한 주소
    String specificInfo; //주차 여부, 찾아 오는 상세한 길 같은 구단 등록주가 상세히 입력하는 폼.
    List<Court> courts;
}
