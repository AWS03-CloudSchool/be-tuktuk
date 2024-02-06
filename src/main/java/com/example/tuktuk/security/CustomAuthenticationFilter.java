package com.example.tuktuk.security;

import com.example.tuktuk.users.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.filter.OncePerRequestFilter;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.GetUserRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.GetUserResponse;

import java.io.IOException;
import java.util.List;

@Slf4j
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("CustomAuthenticationFilter accessed");

        // HTTPS 헤더에서 토큰을
        String accessToken = request.getHeader("Authorization");

        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder()
                .region(Region.AP_NORTHEAST_2)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();

        //accesstoken 바탕으로 user정보 가져오는 내용
        GetUserResponse userResponse = cognitoClient.getUser(GetUserRequest.builder()
                .accessToken(accessToken)
                .build());

        //사용자 정보 출력
        List<AttributeType> attributeTypes = userResponse.userAttributes();
        String sub = null;
        String email = null;
        for(AttributeType attribute: attributeTypes){
            if("sub".equals(attribute.name())){
                sub = attribute.value();
            }else if("email".equals(attribute.name())){
                email = attribute.value();
            }
        }
        log.info("sub={}",sub);
        log.info("email={}",email);

        //유효하지 않은 토큰의 경우
        if(sub == null && email == null){
            throw new IllegalStateException("토큰을 재발급 해주세요");
        }


        request.setAttribute("sub",sub);
        request.setAttribute("email",email);

        filterChain.doFilter(request, response);
    }
}
