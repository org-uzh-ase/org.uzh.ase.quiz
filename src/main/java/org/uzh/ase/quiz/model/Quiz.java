package org.uzh.ase.quiz.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class Quiz {
    private String description;
    private List<Movie> answers;
    private String correctAnswer;

    public String getDescription() {
        return description;
    }

    public List<Movie> getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public Quiz(){
    this.description = "Woody, a good-hearted cowboy doll who belongs to a young boy named Andy, sees his position as Andy's favorite toy jeopardized when his mom buys him a Buzz Lightyear action figure. Even worse, the arrogant Buzz thinks he's a real spaceman on a mission to return to his home planet. When Andy's family moves to a new house, Woody and Buzz must escape the clutches of maladjusted neighbor Sid Phillips and reunite with their boy.";
    List<Movie> answers = new ArrayList<>();
    answers.add(new Movie("114709", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Toy_Story_logo.svg", "Toy Story", "SAND1"));
    answers.add(new Movie("", "https://upload.wikimedia.org/wikipedia/de/f/f0/Toy_Story_2.svg", "Toy Story 2", "SAND2"));
    answers.add(new Movie("", "https://upload.wikimedia.org/wikipedia/de/6/6a/Toy_Story_3.svg", "Toy Story 3", "SAND3"));
    answers.add(new Movie("", "https://upload.wikimedia.org/wikipedia/de/9/93/Toy_Story_4.jpeg", "Toy Story 4", "SAND4"));
    this.answers = answers;
    this.correctAnswer = "SAND";
}

public Quiz(String description, List<Movie> answers, String correctAnswer){
    this.description = description;
    this.answers = answers;
    this.correctAnswer = correctAnswer;
    }
}
