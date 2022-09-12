package com.example.matches.utilities.exceptions;

import com.example.matches.utilities.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MatchNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(MatchNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<Object> matchNotFoundHandler(MatchNotFoundException ex) {
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.NOT_FOUND, null);
    }
}