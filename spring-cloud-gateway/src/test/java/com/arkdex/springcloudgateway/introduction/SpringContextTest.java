package com.arkdex.springcloudgateway.introduction;

import com.arkdex.springcloudgateway.introduction.IntroductionGatewayApplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = IntroductionGatewayApplication.class)
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
