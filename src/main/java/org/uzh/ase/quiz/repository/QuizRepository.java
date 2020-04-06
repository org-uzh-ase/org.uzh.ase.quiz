package org.uzh.ase.quiz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.uzh.ase.quiz.model.Quiz;

import java.util.List;

public interface QuizRepository extends MongoRepository<Quiz, String> {
    List<Quiz> findByImdbId(String imdb);
}
