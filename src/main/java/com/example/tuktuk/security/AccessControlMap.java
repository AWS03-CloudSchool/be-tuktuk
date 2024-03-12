package com.example.tuktuk.security;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccessControlMap {
    /*
      HTTP Method, Allow URI 의 쌍으로 허용할 URI를 저장한다.
    */
    private final Map<AccessControlRecord, Boolean> accessControlMap = new HashMap<>();

    public AccessControlMap() {
        accessControlMap.put(AccessControlRecord.from("GET", "/stadiums"), Boolean.TRUE);
        accessControlMap.put(AccessControlRecord.from("GET", "/schedules"), Boolean.TRUE);
        accessControlMap.put(AccessControlRecord.from("GET", "/login"), Boolean.TRUE);
        accessControlMap.put(AccessControlRecord.from("POST", "/users"), Boolean.TRUE);
        accessControlMap.put(AccessControlRecord.from("POST", "/fieldowners"), Boolean.TRUE);
        accessControlMap.put(AccessControlRecord.from("GET", "/my-stadiums"), Boolean.FALSE);
        accessControlMap.put(AccessControlRecord.from("GET", "/my-schedules"), Boolean.FALSE);
    }

    public boolean checkURI(String httpMethod, String requestUri) {
        for (AccessControlRecord record : accessControlMap.keySet().stream().toList()) {
            if (record.getHttpMethod().equals(httpMethod) && requestUri.contains(record.getUri())) {
                return accessControlMap.get(record);
            }
        }

        return false;
    }
}
