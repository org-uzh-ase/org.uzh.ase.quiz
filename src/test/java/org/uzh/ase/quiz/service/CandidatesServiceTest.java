package org.uzh.ase.quiz.service;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.uzh.ase.quiz.model.Movie;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link org.uzh.ase.quiz.service.CandidatesService}
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CandidatesServiceTest {

    /**
     * The actual call to the Candidates Microservice is mocked.
     */
    @Mock
    private RestTemplate restTemplate;

    /**
     * The candidates service works as it would in production except that the REST call to the Candidates Microservice is mocked.
     */
    @InjectMocks
    private CandidatesService candidatesService = new CandidatesService();

    /**
     * Verify that the candidates service returns a list of {@link org.uzh.ase.quiz.model.Movie} with codes.
     */
    @Test
    public void testGetCandidates(){
        Movie movie1 = new Movie("1234548", "https://images-na.ssl-images-amazon.com/images/M/MV5BMjIwOTQwNzg1MV5BMl5BanBnXkFtZTcwODc4MDU4Mg@@._V1_UX182_CR0,0,182,268_AL_.jpg", "The Men Who Stare at Goats", null);
        Movie movie2 = new Movie("2318527", "https://images-na.ssl-images-amazon.com/images/M/MV5BNzAwODI0MzAwOF5BMl5BanBnXkFtZTcwODkzMTc4OQ@@._V1_UX182_CR0,0,182,268_AL_.jpg", "Hell Baby", null);
        Movie movie3 = new Movie("3745840", "https://images-na.ssl-images-amazon.com/images/M/MV5BNDg4NjE3NTg2OV5BMl5BanBnXkFtZTgwODY1ODU5NjE@._V1_UY268_CR9,0,182,268_AL_.jpg", "Expecting Amish", null);
        Movie movie4 = new Movie("3528666", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0MzA1MDQyN15BMl5BanBnXkFtZTgwMDA1Mzk2NDE@._V1_UY268_CR4,0,182,268_AL_.jpg", "The Marine 4: Moving Target", null);

        Movie[] movies = {movie1, movie2, movie3, movie4};
        Mockito.when(restTemplate.getForObject("http://localhost:8082/api/candidates?movie_id=" + "1234548" + "&level=" + 1, Movie[].class))
                .thenReturn(movies);

        List<Movie> response = candidatesService.getCandidates("1234548", 1);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.get(0).getCode());
        Assert.assertNotNull(response.get(1).getCode());
        Assert.assertNotNull(response.get(2).getCode());
        Assert.assertNotNull(response.get(3).getCode());
    }

    /**
     * Verify that the base URL used for the REST call to the Candidates Microservice is set
     */
    @Test
    public void testBaseurl(){
        assertFalse(StringUtils.isEmpty(candidatesService.getBaseurl()));
    }
}
