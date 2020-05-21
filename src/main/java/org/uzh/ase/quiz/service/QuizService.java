package org.uzh.ase.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.uzh.ase.quiz.model.Movie;
import org.uzh.ase.quiz.model.MovieDB;
import org.uzh.ase.quiz.model.Quiz;

import java.util.List;

/**
 * This service is responsible to build the quiz objected which is returned by the {@link org.uzh.ase.quiz.rest.QuizController}.
 */
@Service
public class QuizService {
    @Autowired
    CandidatesService candidatesService;

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * Returns the Quiz object which will be returned in {@link org.uzh.ase.quiz.rest.QuizController}.
     * @param level level of difficulty (easy = 1, medium = 2, hard = 3)
     * @return {@link org.uzh.ase.quiz.model.Quiz} object
     */
    public Quiz getQuiz(int level){
        MovieDB movieDB = randomSample();
        List<Movie> movies = candidatesService.getCandidates(movieDB.getId(), level);

        return new Quiz(movieDB.getDescription(), movies, movies.get(0).getCode());
    }

    /**
     * Returns a random movie document from the database
     * @return {@link org.uzh.ase.quiz.model.MovieDB}
     */
    public MovieDB randomSample(){
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(new Criteria("overview").exists(true)),
                Aggregation.sample(1)
        );
        return mongoTemplate.aggregate(agg, MovieDB.class, MovieDB.class).getMappedResults().get(0);
    }
}
