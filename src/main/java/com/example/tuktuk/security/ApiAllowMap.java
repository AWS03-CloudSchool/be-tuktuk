package com.example.tuktuk.security;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class ApiAllowMap {
  /*
    HTTP Method, Allow URI 의 쌍으로 허용할 URI를 저장한다.
  */
  private MultiValueMap<String, String> allowMap = new LinkedMultiValueMap<>();

  public ApiAllowMap() {
    allowMap.add("GET", "/schedule");
    allowMap.add("GET", "/courts");
    allowMap.add("GET", "/stadiums");
    allowMap.add("GET", "/login");
    allowMap.add("POST", "/users");
    allowMap.add("POST", "/fieldowners");
  }

  public boolean isAllowURI(String httpMethod, String requestUri) {
    for (String allowUri : allowMap.get(httpMethod)) {
      if (requestUri.contains(allowUri)) {
        return true;
      }
    }

    return false;
  }
}
