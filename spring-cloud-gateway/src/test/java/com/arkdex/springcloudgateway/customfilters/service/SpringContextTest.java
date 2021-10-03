package com.arkdex.springcloudgateway.customfilters.service;

import com.arkdex.springcloudgateway.customfilters.service.ServiceApplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ServiceApplication.class)
public class SpringContextTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
