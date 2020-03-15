package org.uzh.ase.microservice.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.uzh.ase.microservice.example.model.Example;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void compTest() {
		Example t = new Example();
		System.out.println(t.comp(9));
	}

}
