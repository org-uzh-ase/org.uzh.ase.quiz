package org.uzh.ase.microservice.example.model;

public class Example {
    private final String text;

    public Example(){
        this.text = "Hello World!";
    }

    public String getText() {
        return text;
    }

    public int comp(Integer x) {
        int y = 4;
        int z = 6;
        return x * z;
    }
}
