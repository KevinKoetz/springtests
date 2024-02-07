package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest(classes = {WebClient.class})
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
