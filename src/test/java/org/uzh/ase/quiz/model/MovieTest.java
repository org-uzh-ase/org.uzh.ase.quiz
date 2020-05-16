package org.uzh.ase.quiz.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test for {@link org.uzh.ase.quiz.model.Movie}
 */
@SpringBootTest
public class MovieTest {

    /**
     * Test the instantiation of a {@link org.uzh.ase.quiz.model.Movie} object
     */
    @Test
    public void testMovie(){
        Movie movie = new Movie("test-imdbId", "./poster.png", "Test Movie", "test-id");
        Assert.assertNotNull(movie);
        Assert.assertEquals("./poster.png", movie.getPoster() );
        Assert.assertEquals("test-imdbId", movie.getId() );
        Assert.assertEquals("Test Movie", movie.getTitle() );
        Assert.assertEquals("test-id", movie.getCode());
    }
}
