package com.jovscb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JenkinsMavenProjectApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void addTest() {
		CalculatorService service = new CalculatorService();
		assertEquals(10, service.add(5, 5));
	}



}
