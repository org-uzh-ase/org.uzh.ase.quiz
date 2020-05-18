package org.uzh.ase.quiz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Java Representation of the MongoDB document "movies". Not to be confused with {@link org.uzh.ase.quiz.model.Movie}
 * which is the Data Transfer Object used in the REST API.
 */
@Document(collection = "movies")
public class MovieDB {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Field("imdb_id")
    private String imdbId;

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @Field("overview")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Field("title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * MovieDB constructor
     * @param imdbId IMDB movie ID
     * @param description description of the movie
     * @param title Title of the movie
     */
    public MovieDB(String imdbId, String description, String title){
        this.imdbId = imdbId;
        this.description = description;
        this.title = title;
    }
}
