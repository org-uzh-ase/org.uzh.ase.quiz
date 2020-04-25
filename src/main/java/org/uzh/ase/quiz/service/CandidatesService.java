package org.uzh.ase.quiz.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.uzh.ase.quiz.model.Movie;
import org.uzh.ase.quiz.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatesService {
    final String baseUrl = "http://localhost:8082/";

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getCandidates(String movieId, int level) {
        RestTemplate restTemplate = new RestTemplate();
        Movie[] response = restTemplate.getForObject(baseUrl + "api/candidates?movie_id=" + movieId + "&level=" + String.valueOf(level), Movie[].class);

        List<Movie> result = new ArrayList<>();

        for(Movie movie : response){
            movie.setCode(getRandomCode(level));
            movie.setTitle(movieRepository.findByid(movie.getId()).getTitle());
            result.add(movie);
        }
        return result;
    }

    public String getRandomCode(int level){
       return RandomStringUtils.random(4 + level, true, false);
    }
}
