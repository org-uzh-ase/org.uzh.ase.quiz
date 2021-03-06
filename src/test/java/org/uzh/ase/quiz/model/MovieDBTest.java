package org.uzh.ase.quiz.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test for {@link org.uzh.ase.quiz.model.MovieDB}
 */
@SpringBootTest
public class MovieDBTest {

    /**
     * Test the instantiation of a {@link org.uzh.ase.quiz.model.MovieDB} object
     */
    @Test
    public void testMovieDB(){
        MovieDB movie = new MovieDB("test-imdbId", "some description", "Test Movie");
        Assert.assertNotNull(movie);
        Assert.assertNull(movie.getId());
        Assert.assertEquals("some description", movie.getDescription() );
        Assert.assertEquals("test-imdbId", movie.getImdbId() );
        Assert.assertEquals("Test Movie", movie.getTitle() );
        movie.setId("test-id");
        Assert.assertEquals("test-id", movie.getId());

        movie.setId("something");
        Assert.assertEquals("something", movie.getId());
        movie.setTitle("SAND");
        Assert.assertEquals("SAND", movie.getTitle());
        movie.setDescription("something else");
        Assert.assertEquals("something else", movie.getDescription());
        movie.setImdbId("some id");
        Assert.assertEquals("some id", movie.getImdbId());
    }
}
