package org.uzh.ase.quiz.model;

import java.util.List;
/**
 * Data Transfer Object between Frontend and Quiz Microservice.
 */
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

    /**
     * Quiz constructor
     * @param description Description of the movie we are looking for
     * @param answers Possible answers to the movie quiz, a list of {@link org.uzh.ase.quiz.model.Movie}
     * @param correctAnswer Code of the correct movie answer
     */
    public Quiz(String description, List<Movie> answers, String correctAnswer){
    this.description = description;
    this.answers = answers;
    this.correctAnswer = correctAnswer;
    }
}
