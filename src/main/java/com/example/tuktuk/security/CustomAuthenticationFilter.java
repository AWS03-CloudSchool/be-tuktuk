package com.example.tuktuk.security;

import com.example.tuktuk.users.auth.UserInfo;
import com.example.tuktuk.users.auth.UserInfoProvider;
import com.example.tuktuk.users.domain.User;
import com.example.tuktuk.users.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;

import java.io.IOException;
import java.util.List;

@Slf4j
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final UserInfoProvider userInfoProvider;
    private final UserRepository userRepository;

    public CustomAuthenticationFilter(UserInfoProvider userInfoProvider, UserRepository userRepository) {
        this.userInfoProvider = userInfoProvider;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /*
            회원가입 및 로그인, 조회 요청은 토큰 유효성 검사를 실시하지 않는다.
        */
        if (checkPassUrl(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        log.info("CustomAuthenticationFilter accessed");
        //토큰 유효성 검사
        String accessToken = request.getHeader("Authorization");

        if (accessToken != null) {//토큰 유효성 검사를 해야하는 경우
            if (isValidToken(accessToken)) {
                filterChain.doFilter(request, response);
                return;
            }
            throw new IllegalStateException("토큰을 재발급받아야 합니다.");
        }
    }

    private boolean isValidToken(String accessToken) {
        String id = null;
        try {
            List<AttributeType> attributeTypes = userInfoProvider.getUserInfoFromAuthServer(accessToken);
            UserInfo userInfo = new UserInfo(attributeTypes);
            id = userInfo.getId();
        } catch (Exception e) {
            return false;
        }

        User user = userRepository.findById(id).get();
        log.info("user.roles={}",user.getRoles());
        this.saveAuthenticationToSecurityContextHolder(user);//securityContext에 유저 저장

        return true;
    }

    private void saveAuthenticationToSecurityContextHolder(User user) {
        CustomUserDetails userDetails = new CustomUserDetails(user);

        // 인가 처리가 정상적으로 완료된다면 Authentication 객체 생성
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private boolean checkPassUrl(HttpServletRequest request){
        String requestHttpMethod = request.getMethod();
        String requestURI = request.getRequestURI();

        if (("GET".equals(requestHttpMethod) && "/login".equals(requestURI)) ||
                ("POST".equals(requestHttpMethod) && "/users".equals(requestURI)) ||
                ("POST".equals(requestHttpMethod) && "/fieldowners".equals(requestURI))) {
            return true;
        }

//        if(("GET".equals(requestHttpMethod) && requestURI.contains("/schedules")))
//            return true;
//
//        if(("GET".equals(requestHttpMethod) && requestURI.contains("/courts")))
//            return true;
//
//        if(("GET".equals(requestHttpMethod) && requestURI.contains("/stadiums")))
//            return true;

        return false;
    }
}
