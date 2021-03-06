package org.uzh.ase.quiz.rest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.uzh.ase.quiz.model.Movie;
import org.uzh.ase.quiz.model.MovieDB;
import org.uzh.ase.quiz.model.Quiz;
import org.uzh.ase.quiz.service.QuizService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Test for {@link org.uzh.ase.quiz.rest.QuizController}
 */
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class QuizControllerTest {
    /**
     * The {@link org.uzh.ase.quiz.service.QuizService} needs to be mocked because it makes a REST call to the Candidates Microservice
     */
    @Mock
    QuizService quizService;

    /**
     * {@link QuizController} is mocked. For a more detailed test of the quiz service, which is used, checkout {@link org.uzh.ase.quiz.service.QuizServiceTest}
     */
    @InjectMocks
    QuizController quizController = new QuizController();
    /**
     * Verify that the {@link org.uzh.ase.quiz.rest.QuizController} returns a valid quiz object
     */
    @Test
    public void testGetQuiz(){
        Movie movie1 = new Movie("1234548", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjIwOTQwNzg1MV5BMl5BanBnXkFtZTcwODc4MDU4Mg@@._V1_UX182_CR0,0,182,268_AL_.jpg", "The Men Who Stare at Goats", "klGjO");
        Movie movie2 = new Movie("2318527", "https://images-na.ssl-images-amazon.com/images/M/MV5BNzAwODI0MzAwOF5BMl5BanBnXkFtZTcwODkzMTc4OQ@@._V1_UX182_CR0,0,182,268_AL_.jpg", "Hell Baby", "IPrYs");
        Movie movie3 = new Movie("3745840", "https://images-na.ssl-images-amazon.com/images/M/MV5BNDg4NjE3NTg2OV5BMl5BanBnXkFtZTgwODY1ODU5NjE@._V1_UY268_CR9,0,182,268_AL_.jpg", "Expecting Amish", "hWiSa");
        Movie movie4 = new Movie("3528666", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0MzA1MDQyN15BMl5BanBnXkFtZTgwMDA1Mzk2NDE@._V1_UY268_CR4,0,182,268_AL_.jpg", "The Marine 4: Moving Target", "RknWk");

        List<Movie> movies = new ArrayList<>();
        Collections.addAll(movies, movie1, movie2, movie3, movie4);

        MovieDB moviedb1 = new MovieDB("1234548", "some description", "The Men Who Stare at Goats");

        Quiz quiz = new Quiz(moviedb1.getDescription(), movies, movies.get(0).getCode());

        Mockito.when(quizService.getQuiz(1)).thenReturn(quiz);

        Quiz response = quizController.getQuiz(1);

        Assert.assertNotNull(response);
        Assert.assertEquals(moviedb1.getDescription(), response.getDescription());
        Assert.assertEquals(movie1.getCode(), response.getCorrectAnswer());
    }

}
