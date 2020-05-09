package org.uzh.ase.quiz.service;

import java.io.File;
import java.io.FileInputStream;
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

/**
 * This service is responsible to make a REST call to the Candidates Microservice (hence the name).
 */
@Service
public class CandidatesService {
    private String baseUrl;

    public CandidatesService(){
        baseUrl = "http://" + getBaseurl() + ":8082/";
    }

    @Autowired
    RestTemplate restTemplate;

    /**
     * Get the base URL to where the Candidates Service is running.
     * @return configured base URL from ./config.properties or localhost if no such file is found
     */
    public String getBaseurl(){
        Properties properties = new Properties();

        try {
            File initialFile = new File("./config.properties");
            InputStream inputStream = new FileInputStream(initialFile);

            properties.load(inputStream);

            return properties.get("basePath").toString();
        }
        catch (Exception e){
            return "localhost";
        }
    }

    /**
     * This method makes the call to the candidate microservice.
     * @param movieId is the imdb id of the movie for which you want to get three decoy movies
     * @param level level of difficulty (easy = 1, medium = 2, hard = 3)
     * @return a list of Movie objects returned by the candidate microservice
     */
    public List<Movie> getCandidates(String movieId, int level) {
        Movie[] response = restTemplate.getForObject(baseUrl + "api/candidates?movie_id=" + movieId + "&level=" + level, Movie[].class);

        List<Movie> result = new ArrayList<>();

        for(Movie movie : response){
            movie.setCode(getRandomCode(level));
            result.add(movie);
        }
        return result;
    }

    /**
     * Generates a random code.
     * @param level level of difficulty. This parameter will influence the length of the generated code: The higher the longer the code
     * @return A random code used in the quiz object
     */
    @SuppressWarnings("java:S2245") // suppressed because it is compliant by using SecureRandom instead of Random
    public String getRandomCode(int level){
       return RandomStringUtils.random(4 + level, 0, 0, true, false, (char[])null, new SecureRandom());
    }
}
