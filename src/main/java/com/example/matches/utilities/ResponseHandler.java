package com.example.matches.utilities;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("timestamp", LocalDate.now());
        map.put("status", status.value());

        if (status.equals(HttpStatus.OK) || status.equals(HttpStatus.CREATED)) {
            if (responseObj != null) {
                map.put("data", responseObj);
            }

            map.put("message", message);
        } else {
            map.put("error", message);
        }

        return new ResponseEntity<Object>(map, status);
    }
}
