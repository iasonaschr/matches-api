package com.example.matches.utilities.exceptions;

import com.example.matches.utilities.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.format.DateTimeParseException;


@ControllerAdvice
public class DateTimeParseAdvice {
    @ResponseBody
    @ExceptionHandler(DateTimeParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Object> badDateTimeFormatHandler(DateTimeParseException ex) {
        return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, null);
    }
}
