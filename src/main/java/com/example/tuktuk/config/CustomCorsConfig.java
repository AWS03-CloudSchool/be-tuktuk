package com.example.tuktuk.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomCorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "https://www.tukktukk.com")
                .allowedMethods("GET", "DELETE", "OPTIONS")
                .allowedHeaders("Authorization")
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .maxAge(3000) // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
                .exposedHeaders(HttpHeaders.AUTHORIZATION);

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "https://www.tukktukk.com")
                .allowedMethods("POST", "PUT", "PATCH", "OPTIONS")
                .allowedHeaders("Authorization")
                .allowedHeaders("Content-Type")
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .maxAge(3000) // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
                .exposedHeaders(HttpHeaders.AUTHORIZATION);


    }

}