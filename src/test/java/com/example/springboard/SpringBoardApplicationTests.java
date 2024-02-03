package com.example.springboard;

import com.p6spy.engine.spy.P6SpyDriver;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoardApplicationTests {

    @Test
    void contextLoads() {
        // p6spy 드라이버 등록
        try {
            Class.forName(P6SpyDriver.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
