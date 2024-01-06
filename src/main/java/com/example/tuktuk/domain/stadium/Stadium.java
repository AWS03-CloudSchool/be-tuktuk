package com.example.tuktuk.domain.stadium;

import com.example.tuktuk.domain.member.Member;
import lombok.Getter;

import java.util.List;

@Getter
public class Stadium {

    String Name;
    Member owner;
    Location location;
    String specificInfo; //주차 여부, 찾아 오는 상세한 길 같은 구단 등록주가 상세히 입력하는 폼.
    List<Court> courts;
}
