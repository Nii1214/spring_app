package com.example.spring_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// http://localhost:8080/

@Controller
public class firstController {
    @GetMapping("/")
    public String first() {
        return "firstview";
    }
}
