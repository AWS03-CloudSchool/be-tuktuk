package com.example.tuktuk.domain.member;

import com.example.tuktuk.domain.global.City;
import com.example.tuktuk.domain.global.Province;
import lombok.Getter;

@Getter
public class Residence {
    private Province province;//도 또는 시
    private City city;//시, 군, 구 등
}
