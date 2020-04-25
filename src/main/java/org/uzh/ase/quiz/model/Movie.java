package org.uzh.ase.quiz.model;

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

public Movie(String id, String poster, String title, String code){
    this.id = id;
    this.title = title;
    this.poster = poster;
    this.code = code;
}

}
