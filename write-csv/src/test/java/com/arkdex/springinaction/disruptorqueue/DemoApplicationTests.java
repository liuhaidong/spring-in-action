package com.arkdex.springinaction.disruptorqueue;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		new WriteExampleBean("A","B","C");
	}

}
