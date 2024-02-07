package com.example.tuktuk.security;

import com.example.tuktuk.users.auth.UserInfo;
import com.example.tuktuk.users.auth.UserInfoProvider;
import com.example.tuktuk.users.domain.Provider;
import com.example.tuktuk.users.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.filter.OncePerRequestFilter;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;

import java.io.IOException;
import java.util.List;

@Slf4j
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;

    private final UserInfoProvider userInfoProvider;
    private final UserRepository userRepository;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager, UserInfoProvider userInfoProvider, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userInfoProvider = userInfoProvider;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if ("/login".equals(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }
        log.info("CustomAuthenticationFilter accessed");



        // HTTPS 헤더에서 토큰을
        String accessToken = request.getHeader("Authorization");

        List<AttributeType> attributeTypes = userInfoProvider.getUserInfoFromAuthServer(accessToken);
        UserInfo userInfo = new UserInfo(attributeTypes);

        String id = userInfo.getId();
        String email = userInfo.getEmail();
        Provider provider = userInfo.getProvider();

        log.info("id={}",id);
        log.info("email={}",email);
        log.info("provider={}",provider.name());

        //유효하지 않은 토큰의 경우
        if(id == null && email == null){
            throw new IllegalStateException("토큰을 재발급 해주세요");
        }


        request.setAttribute("id",id);
        request.setAttribute("email",email);
        request.setAttribute("provider",provider);

        filterChain.doFilter(request, response);
    }
}
