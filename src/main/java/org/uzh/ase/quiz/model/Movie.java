package org.uzh.ase.quiz.model;

/**
 * Data Transfer Object between Frontend and Quiz Microservice and between Quiz Microservice and the Candidate Microservice. Not to be confused with {@link org.uzh.ase.quiz.model.MovieDB}
 * which is the representation of the MongoDB document "movies".
 */
public class Movie {
    private String id;
    private String title;
    private String poster;
    private String code;


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Movie(){}

    /**
     * Movie Constructor
     * @param id IMDB movie ID
     * @param poster URL pointing to a poster representing the movie
     * @param title Title of the movie
     * @param code Code randomly assigned to a movie
     */
    public Movie(String id, String poster, String title, String code){
    this.id = id;
    this.title = title;
    this.poster = poster;
    this.code = code;
}

}
