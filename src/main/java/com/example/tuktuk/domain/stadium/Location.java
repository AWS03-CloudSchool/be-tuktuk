package com.example.tuktuk.domain.stadium;

import com.example.tuktuk.domain.global.City;
import com.example.tuktuk.domain.global.Province;
import lombok.Getter;

@Getter
public class Location {
    private Province province;//도 또는 시
    private City city;//시, 군, 구 등
    private String roadNameAddress;//도로명 주소
}
