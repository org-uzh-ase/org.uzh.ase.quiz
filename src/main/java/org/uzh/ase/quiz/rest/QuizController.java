package org.uzh.ase.quiz.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.uzh.ase.quiz.model.Quiz;

@RestController
public class QuizController {
        @RequestMapping(path = "/api/quizzes/quiz", method = RequestMethod.GET)
        public Quiz getQuiz(@RequestParam(value = "level", defaultValue="1") String level){
            return new Quiz();
        }
}

