package org.uzh.ase.quiz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.uzh.ase.quiz.model.MovieDB;

public interface MovieRepository extends MongoRepository<MovieDB, String> {
    MovieDB findByid(String id);
    MovieDB findByimdbId(String imdbId);
}
