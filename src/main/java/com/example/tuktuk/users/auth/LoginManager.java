//package com.example.tuktuk.users.auth;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;
//
//import java.util.List;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class LoginManager {
//
//    private final TokenProvider tokenProvider;
//
//    private final UserInfoProvider userInfoProvider;
//
//    public String validateLogin(String code){
//        TokenInfo token = tokenProvider.getToken(code);
//        List<AttributeType> attributeTypes = userInfoProvider.getUserInfoFromAuthServer(token.getAccess_token());
//        UserInfo userInfo = new UserInfo(attributeTypes);
//        log.info("Id={}",userInfo.getId());
//        log.info("email={}",userInfo.getEmail());
//        log.info("provider={}",userInfo.getProvider());
//
//        return token.getAccess_token();
//    }
//
//}
