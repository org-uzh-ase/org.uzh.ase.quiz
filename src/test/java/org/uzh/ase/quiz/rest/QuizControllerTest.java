package org.uzh.ase.quiz.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.uzh.ase.quiz.model.Movie;
import org.uzh.ase.quiz.model.Quiz;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuizControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getQuizTest() throws Exception {
        Quiz quiz = this.restTemplate.getForObject("http://localhost:" + port + "/api/quizzes/quiz", Quiz.class);
        assertThat(quiz).isNotNull();

        assertThat(quiz.getAnswers()).isNotEmpty();
        assertThat(quiz.getAnswers().size()).isEqualTo(4);
        assertThat(quiz.getAnswers().get(0)).isNotNull();
        assertThat(quiz.getAnswers().get(1)).isNotNull();
        assertThat(quiz.getAnswers().get(2)).isNotNull();
        assertThat(quiz.getAnswers().get(3)).isNotNull();

        assertThat(quiz.getCorrectAnswer()).isNotEmpty();
        assertThat(quiz.getDescription()).isNotEmpty();

    }
}
