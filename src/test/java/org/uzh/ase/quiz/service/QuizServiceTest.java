package org.uzh.ase.quiz.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.uzh.ase.quiz.model.Movie;
import org.uzh.ase.quiz.model.MovieDB;
import org.uzh.ase.quiz.model.Quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class QuizServiceTest {
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    MongoTemplate mongoTemplate;

    @Mock
    CandidatesService candidatesService;

    @InjectMocks
    private QuizService quizService = new QuizService();

    @Test
    public void testGetQuiz(){
        Movie movie1 = new Movie("1234548", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjIwOTQwNzg1MV5BMl5BanBnXkFtZTcwODc4MDU4Mg@@._V1_UX182_CR0,0,182,268_AL_.jpg", "The Men Who Stare at Goats", "klGjO");
        Movie movie2 = new Movie("2318527", "https://images-na.ssl-images-amazon.com/images/M/MV5BNzAwODI0MzAwOF5BMl5BanBnXkFtZTcwODkzMTc4OQ@@._V1_UX182_CR0,0,182,268_AL_.jpg", "Hell Baby", "IPrYs");
        Movie movie3 = new Movie("3745840", "https://images-na.ssl-images-amazon.com/images/M/MV5BNDg4NjE3NTg2OV5BMl5BanBnXkFtZTgwODY1ODU5NjE@._V1_UY268_CR9,0,182,268_AL_.jpg", "Expecting Amish", "hWiSa");
        Movie movie4 = new Movie("3528666", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0MzA1MDQyN15BMl5BanBnXkFtZTgwMDA1Mzk2NDE@._V1_UY268_CR4,0,182,268_AL_.jpg", "The Marine 4: Moving Target", "RknWk");

        List<Movie> movies = new ArrayList<>();
        Collections.addAll(movies, movie1, movie2, movie3, movie4);

        MovieDB moviedb1 = new MovieDB("1234548", "some description", "The Men Who Stare at Goats");
        moviedb1.setId("1234548");
        Mockito.when(mongoTemplate.aggregate(Mockito.any(Aggregation.class), Mockito.eq(MovieDB.class), Mockito.eq(MovieDB.class)).getMappedResults().get(Mockito.eq(0)))
                .thenReturn(moviedb1);

        Mockito.when(candidatesService.getCandidates("1234548", 1))
        .thenReturn(movies);

        Quiz quiz = quizService.getQuiz(1);

        Assert.assertNotNull(quiz);
        Assert.assertEquals(moviedb1.getDescription(), quiz.getDescription());
        Assert.assertEquals(movie1.getCode(), quiz.getCorrectAnswer());
    }
}
