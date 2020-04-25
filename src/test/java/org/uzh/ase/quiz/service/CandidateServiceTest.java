package org.uzh.ase.quiz.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.uzh.ase.quiz.model.Movie;
import org.uzh.ase.quiz.model.MovieDB;
import org.uzh.ase.quiz.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CandidateServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    private CandidatesService candidatesService = new CandidatesService();

    @Test
    public void testGetCandidates(){
        Movie movie1 = new Movie("1234548", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjIwOTQwNzg1MV5BMl5BanBnXkFtZTcwODc4MDU4Mg@@._V1_UX182_CR0,0,182,268_AL_.jpg", null, null);
        Movie movie2 = new Movie("2318527", "https://images-na.ssl-images-amazon.com/images/M/MV5BNzAwODI0MzAwOF5BMl5BanBnXkFtZTcwODkzMTc4OQ@@._V1_UX182_CR0,0,182,268_AL_.jpg", null, null);
        Movie movie3 = new Movie("3745840", "https://images-na.ssl-images-amazon.com/images/M/MV5BNDg4NjE3NTg2OV5BMl5BanBnXkFtZTgwODY1ODU5NjE@._V1_UY268_CR9,0,182,268_AL_.jpg", null, null);
        Movie movie4 = new Movie("3528666", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0MzA1MDQyN15BMl5BanBnXkFtZTgwMDA1Mzk2NDE@._V1_UY268_CR4,0,182,268_AL_.jpg", null, null);

        Movie[] movies = {movie1, movie2, movie3, movie4};
        Mockito.when(restTemplate.getForObject("http://localhost:8082/api/candidates?movie_id=" + "1234548" + "&level=" + 1, Movie[].class))
                .thenReturn(movies);

        Mockito.when(movieRepository.findByid("1234548"))
                .thenReturn(new MovieDB("1234548", "some description", "The Men Who Stare at Goats"));
        Mockito.when(movieRepository.findByid("2318527"))
                .thenReturn(new MovieDB("2318527", "some description", "Hell Baby"));
        Mockito.when(movieRepository.findByid("3745840"))
                .thenReturn(new MovieDB("3745840", "some description", "Expecting Amish"));
        Mockito.when(movieRepository.findByid("3528666"))
                .thenReturn(new MovieDB("3528666", "some description", "The Marine 4: Moving Target"));

        List<Movie> response = candidatesService.getCandidates("1234548", 1);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.get(0).getCode());
        Assert.assertNotNull(response.get(1).getCode());
        Assert.assertNotNull(response.get(2).getCode());
        Assert.assertNotNull(response.get(3).getCode());

        Assert.assertNotNull(response.get(0).getTitle());
        Assert.assertNotNull(response.get(1).getTitle());
        Assert.assertNotNull(response.get(2).getTitle());
        Assert.assertNotNull(response.get(3).getTitle());
    }
}
