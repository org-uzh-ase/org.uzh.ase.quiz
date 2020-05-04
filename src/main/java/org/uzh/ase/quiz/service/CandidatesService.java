package org.uzh.ase.quiz.service;

import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.uzh.ase.quiz.model.Movie;

@Service
public class CandidatesService {
    private String baseUrl;

    public CandidatesService(){
        baseUrl = "http://" + getBaseurl() + ":8082/";
    }

    @Autowired
    RestTemplate restTemplate;

    private String getBaseurl(){
        Properties properties = new Properties();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                return "localhost";
            }

            return properties.get("basePath").toString();
        }
        catch (Exception e){
            return "localhost";
        }
    }

    public List<Movie> getCandidates(String movieId, int level) {
        Movie[] response = restTemplate.getForObject(baseUrl + "api/candidates?movie_id=" + movieId + "&level=" + level, Movie[].class);

        List<Movie> result = new ArrayList<>();

        for(Movie movie : response){
            movie.setCode(getRandomCode(level));
            result.add(movie);
        }
        return result;
    }

    @SuppressWarnings("java:S2245") // suppressed because it is compliant by using SecureRandom instead of Random
    public String getRandomCode(int level){
       return RandomStringUtils.random(4 + level, 0, 0, true, false, (char[])null, new SecureRandom());
    }
}
