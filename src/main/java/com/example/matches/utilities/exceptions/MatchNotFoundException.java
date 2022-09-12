package com.example.matches.utilities.exceptions;

public class MatchNotFoundException extends RuntimeException {

    public MatchNotFoundException(Integer id) {
        super("Could not find match with id " + id);
    }
}
