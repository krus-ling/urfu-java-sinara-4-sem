package ru.guk.education.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @RolesAllowed("ADMIN")
    @GetMapping("/admin/api")
    public String adminApi(Authentication auth) {
        return String.format("Привет, %s! Твоя роль: %s😈", auth.getName(), auth.getAuthorities());
    }

}
