package com.example.tuktuk.security;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccessControlRecord {

    private String httpMethod;

    private String uri;

    public static AccessControlRecord from(String httpMethod, String uri){
        return AccessControlRecord.builder()
                .httpMethod(httpMethod)
                .uri(uri)
                .build();
    }
}
