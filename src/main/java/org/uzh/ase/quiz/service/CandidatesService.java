package org.uzh.ase.quiz.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.uzh.ase.quiz.model.Movie;
import org.uzh.ase.quiz.repository.MovieRepository;

@Service
public class CandidatesService {
    static final String BASEURL = "http://candidates:8082/";

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<Movie> getCandidates(String movieId, int level) {
        Movie[] response = restTemplate.getForObject(BASEURL + "api/candidates?movie_id=" + movieId + "&level=" + level, Movie[].class);

        List<Movie> result = new ArrayList<>();

        for(Movie movie : response){
            movie.setCode(getRandomCode(level));
            movie.setTitle(movieRepository.findByid(movie.getId()).getTitle());
            result.add(movie);
        }
        return result;
    }

    @SuppressWarnings("java:S2245") // suppressed because it is compliant by using SecureRandom instead of Random
    public String getRandomCode(int level){
       return RandomStringUtils.random(4 + level, 0, 0, true, false, (char[])null, new SecureRandom());
    }
}
