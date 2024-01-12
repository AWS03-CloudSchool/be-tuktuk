package com.example.tuktuk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DataSourceConfigTest {

    @Autowired
    private Environment env;

    @Test
    public void testReadRoJdbcUrl() {
        // application.yaml에서 'app.datasource.soccer.ro.jdbc-url' 값을 읽어옴
        String roJdbcUrl = env.getProperty("app.datasource.soccer.ro.jdbc-url");

        // 예상 값과 실제 값이 일치하는지 확인
        assertEquals("jdbc:mysql://172.20.1.3:3306/soccer?allowPublicKeyRetrieval=true", roJdbcUrl);
    }
}
