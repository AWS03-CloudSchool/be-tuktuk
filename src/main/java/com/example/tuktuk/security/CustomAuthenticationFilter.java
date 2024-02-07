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
        //회원가입과 로그인은 토큰 유효성 검사 절차를 안 밟는다.
        if (("GET".equals(request.getMethod()) && "/login".equals(request.getRequestURI())) ||
                (("POST".equals(request.getMethod())) && "/users".equals(request.getRequestURI()))) {
            filterChain.doFilter(request, response);
            return;
        }

        log.info("CustomAuthenticationFilter accessed");
        //토큰 유효성 검사
        String accessToken = request.getHeader("Authorization");

        if (accessToken != null) {//토큰 유효성 검사를 해야하는 경우
            if (isValidToken(request, accessToken)) {
                filterChain.doFilter(request, response);
                return;
            }
            throw new IllegalStateException("토큰을 재발급받아야 합니다.");
        }
    }

    private boolean isValidToken(HttpServletRequest request,String accessToken) {
        String id=null;
        try {
            List<AttributeType> attributeTypes = userInfoProvider.getUserInfoFromAuthServer(accessToken);
            UserInfo userInfo = new UserInfo(attributeTypes);
            id = userInfo.getId();
        } catch (Exception e) {
            return false;
        }

        User user = userRepository.findById(id).get();
        request.setAttribute("id",user.getId());
        request.setAttribute("role",user.getRoles());
        log.info("id={}", id);
        log.info("role={}", user.getRoles());
        return true;
    }
}
