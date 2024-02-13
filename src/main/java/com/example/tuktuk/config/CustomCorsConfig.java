package com.example.tuktuk.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomCorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/users")
                .allowedOrigins("http://localhost:3000", "https://www.tukktukk.com")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱

        registry.addMapping("/fieldowners")
                .allowedOrigins("http://localhost:3000", "https://www.tukktukk.com")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱

        registry.addMapping("/stadiums")
                .allowedOrigins("http://localhost:3000", "https://www.tukktukk.com")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("Authorization")
                .allowedHeaders("Content-Type")
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱

//        registry.addMapping("/stadiums")
//                .allowedOrigins("http://localhost:3000", "https://www.tukktukk.com")
//                .allowedMethods("POST", "PUT", "PATCH", "OPTIONS")
//                .allowedHeaders("Authorization")
//                .allowedHeaders("Content-Type")
//                .allowCredentials(true) // 쿠키 인증 요청 허용
//                .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱

        registry.addMapping("/courts")
                .allowedOrigins("http://localhost:3000", "https://www.tukktukk.com")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // POST 메소드만 허용
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "https://www.tukktukk.com")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("Authorization")
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .maxAge(3000) // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
                .exposedHeaders(HttpHeaders.AUTHORIZATION);


    }

}