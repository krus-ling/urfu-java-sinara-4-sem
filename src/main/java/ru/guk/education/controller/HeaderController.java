package ru.guk.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HeaderController {

    @GetMapping("/headers")
    public String showHeaders(HttpServletRequest request, Model model) {
        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            headers.put(header, request.getHeader(header));
        }

        model.addAttribute("headers", headers);
        return "headers";
    }
}
