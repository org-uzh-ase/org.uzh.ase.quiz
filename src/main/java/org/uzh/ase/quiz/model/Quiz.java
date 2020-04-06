package org.uzh.ase.quiz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("quiz")
public class Quiz {
    @Id
    private String id;

    @Indexed
    private String imdbId;

    public String getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

public Quiz(){}

public Quiz(String imdbId){
        this.imdbId = imdbId;
    }

    @Override
    public String toString() {
        return String.format(
                "Quiz[id=%s, imdb_id='%s']",
                id, imdbId);
    }
}
