package com.projeto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class DefaultController {

    @GetMapping
    public ResponseEntity<Map<String, String>> hello() {
        var resp = new HashMap<String, String>();
        resp.put("message", "hello");
        return ResponseEntity.ok(resp);
    }
}
