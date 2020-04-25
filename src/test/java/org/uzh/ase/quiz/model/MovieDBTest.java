package org.uzh.ase.quiz.model;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieDBTest {
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
    }
}