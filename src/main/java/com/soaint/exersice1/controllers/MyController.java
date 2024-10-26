package com.soaint.exersice1.controllers;
import com.soaint.exersice1.models.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class MyController {
     @GetMapping("/{id}")
    public ResponseEntity<String> getWithPathParam(@PathVariable Long id) {
        return ResponseEntity.ok("Received id: " + id);
    }

    @GetMapping
    public ResponseEntity<String> getWithQueryParam(@RequestParam String name) {
        return ResponseEntity.ok("Received name: " + name);
    }

    @PostMapping
    public ResponseEntity<String> postJson(@RequestBody MyRequest request) {
        return ResponseEntity.ok("Received data: " + request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + ex.getMessage());
    }
}
