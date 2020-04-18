package org.uzh.ase.quiz.model;

public class Movie {
    private String imdbId;
    private String title;
    private String poster;
    private String code;

    public String getImdbId() {
        return imdbId;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getCode() {
        return code;
    }

    public Movie(){
    this.imdbId = "114709";
    this.poster = "https://images-na.ssl-images-amazon.com/images/M/MV5BMDU2ZWJlMjktMTRhMy00ZTA5LWEzNDgtYmNmZTEwZTViZWJkXkEyXkFqcGdeQXVyNDQ2OTk4MzI@._V1_UX182_CR0,0,182,268_AL_.jpg";
    this.title = "Toy Story (1995)";
    this.code = "SAND";
}

public Movie(String imdbId, String poster, String title, String code){
    this.imdbId = imdbId;
    this.title = title;
    this.poster = poster;
    this.code = code;
}

}
