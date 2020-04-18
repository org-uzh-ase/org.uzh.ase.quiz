package org.uzh.ase.quiz.rest;

import org.springframework.web.bind.annotation.*;
import org.uzh.ase.quiz.model.Quiz;

@RestController
public class QuizController {
        @GetMapping(path = "/api/quizzes/quiz")
        public Quiz getQuiz(@RequestParam(value = "level", defaultValue="1") String level){
            return new Quiz();
        }
}

