package org.uzh.ase.quiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;
import org.uzh.ase.quiz.model.Quiz;
import org.uzh.ase.quiz.service.QuizService;

/**
 * REST API for the Quiz Microservice
 *
 * <p>More detailed API Documentation available on
 * <a href="https://app.swaggerhub.com/apis-docs/ltoedt/ASE/0.1">SwaggerHub</a>
 * </p>
 */
@RestController
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping(path = "/api/quizzes/quiz")
    public Quiz getQuiz(@RequestParam(value = "level", defaultValue="1") int level){
        try{
            return quizService.getQuiz(level);
        }
        catch(RestClientException e){
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Error in Candidates Microservice: " + e.getMessage());
        }
    }
}

