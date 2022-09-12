package com.example.matches.utilities.exceptions;

import com.example.matches.utilities.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class IllegalStateAdvice {
    @ResponseBody
    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Object> illegalStateHandler(IllegalStateException ex) {
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, null);
    }
}
