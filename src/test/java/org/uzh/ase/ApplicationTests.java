package org.uzh.ase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.uzh.ase.quiz.repository.QuizRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

	@Autowired QuizRepository repository;

	@Test
	void contextLoads() {
	assertThat(repository).isNotNull();
	}

}
