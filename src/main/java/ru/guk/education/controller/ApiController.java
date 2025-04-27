package ru.guk.education.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/limit")
    public String api() {
        return "Успешно🥰";
    }
}
