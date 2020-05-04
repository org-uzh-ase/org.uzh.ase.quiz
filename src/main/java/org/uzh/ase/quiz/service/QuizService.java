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

@Service
public class QuizService {
    @Autowired
    CandidatesService candidatesService;

    @Autowired
    MongoTemplate mongoTemplate;


    public Quiz getQuiz(int level){
        MovieDB movieDB = randomSample();
        List<Movie> movies = candidatesService.getCandidates(movieDB.getId(), level);

        return new Quiz(movieDB.getDescription(), movies, movies.get(0).getCode());
    }

    public MovieDB randomSample(){
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(new Criteria("overview").exists(true)),
                Aggregation.sample(1)
        );
        return mongoTemplate.aggregate(agg, MovieDB.class, MovieDB.class).getMappedResults().get(0);
    }
}
