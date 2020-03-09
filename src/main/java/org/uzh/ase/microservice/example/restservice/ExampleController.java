package org.uzh.ase.microservice.example.restservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.uzh.ase.microservice.example.model.Example;

@RestController
public class ExampleController {

    @RequestMapping("/example")
    public Example example(){
        return new Example();
    }
}