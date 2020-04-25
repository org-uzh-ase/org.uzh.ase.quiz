package org.uzh.ase.quiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.uzh.ase.quiz.model.Quiz;
import org.uzh.ase.quiz.service.QuizService;

@RestController
public class QuizController {
    @Autowired
    QuizService quizService;

        @GetMapping(path = "/api/quizzes/quiz")
        public Quiz getQuiz(@RequestParam(value = "level", defaultValue="1") int level){
            return quizService.getQuiz(level);
        }
}

