package org.uzh.ase.quiz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.uzh.ase.quiz.rest.QuizController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

	@Autowired
	QuizController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
}
