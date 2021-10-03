package com.arkdex.springcloudgateway.customfilters.secondservice;

import com.arkdex.springcloudgateway.customfilters.secondservice.SecondServiceApplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SecondServiceApplication.class)
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
