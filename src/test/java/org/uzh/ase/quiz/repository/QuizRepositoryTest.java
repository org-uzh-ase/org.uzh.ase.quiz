package org.uzh.ase.quiz.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.uzh.ase.quiz.model.Quiz;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class QuizRepositoryTest {

    @Test
    public void testRepository(@Autowired QuizRepository repository){
        repository.deleteAll();

        repository.save(new Quiz("some_id"));
        List<Quiz> quizzes = repository.findByImdbId("some_id");
        assertEquals(1, quizzes.size());
        Quiz quiz = quizzes.get(0);
        assertEquals("some_id", quiz.getImdbId());
        assertNotNull(quiz.getId());
        assertEquals(String.format(
                "Quiz[id=%s, imdb_id='%s']",
                quiz.getId(), "some_id"), quiz.toString());
    }
}
