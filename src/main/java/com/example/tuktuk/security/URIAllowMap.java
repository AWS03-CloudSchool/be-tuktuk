package com.example.tuktuk.security;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class URIAllowMap {
    /*
      HTTP Method, Allow URI 의 쌍으로 허용할 URI를 저장한다.
    */
    private final MultiValueMap<String, String> allowMap = new LinkedMultiValueMap<>();

    public URIAllowMap() {
        allowMap.add("GET", "/stadiums");
        allowMap.add("GET", "/schedules");
        allowMap.add("GET", "/login");
        allowMap.add("POST", "/users");
        allowMap.add("POST", "/fieldowners");
    }

    public boolean isAllowURI(String httpMethod, String requestUri) {
      return allowMap.get(httpMethod)
              .stream()
              .anyMatch(requestUri::contains);
    }
}
