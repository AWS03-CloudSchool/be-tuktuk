package com.example.tuktuk.users.util;

import com.example.tuktuk.security.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextHolderUtil {

    public static String getUserId() {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUser().getId();
    }

    public static String getUsername() {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUsername();
    }
}
