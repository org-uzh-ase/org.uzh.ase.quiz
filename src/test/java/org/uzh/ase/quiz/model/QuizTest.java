package org.uzh.ase.quiz.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class QuizTest {
    @Test
    public void testQuiz(){
        Movie movie1 = new Movie("1234548", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjIwOTQwNzg1MV5BMl5BanBnXkFtZTcwODc4MDU4Mg@@._V1_UX182_CR0,0,182,268_AL_.jpg", "The Men Who Stare at Goats", "klGjO");
        Movie movie2 = new Movie("2318527", "https://images-na.ssl-images-amazon.com/images/M/MV5BNzAwODI0MzAwOF5BMl5BanBnXkFtZTcwODkzMTc4OQ@@._V1_UX182_CR0,0,182,268_AL_.jpg", "Hell Baby", "IPrYs");
        Movie movie3 = new Movie("3745840", "https://images-na.ssl-images-amazon.com/images/M/MV5BNDg4NjE3NTg2OV5BMl5BanBnXkFtZTgwODY1ODU5NjE@._V1_UY268_CR9,0,182,268_AL_.jpg", "Expecting Amish", "hWiSa");
        Movie movie4 = new Movie("3528666", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0MzA1MDQyN15BMl5BanBnXkFtZTgwMDA1Mzk2NDE@._V1_UY268_CR4,0,182,268_AL_.jpg", "The Marine 4: Moving Target", "RknWk");

        List<Movie> movies = new ArrayList<>();
        Collections.addAll(movies, movie1, movie2, movie3, movie4);

        Quiz quiz = new Quiz("some description", movies, "correct-Answer");
        Assert.assertNotNull(quiz);
        Assert.assertEquals("some description", quiz.getDescription() );
        Assert.assertEquals("correct-Answer", quiz.getCorrectAnswer() );
        Assert.assertEquals(4, quiz.getAnswers().size() );
    }
}
