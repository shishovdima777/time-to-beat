package com.timetobeat.timetobeat.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logging")
public class LoggingController {
    @GetMapping()
    public ResponseEntity<String> logging() {
        return new ResponseEntity<>("logging/foreach", HttpStatus.OK);
    }
}
