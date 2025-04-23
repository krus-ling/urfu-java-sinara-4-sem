package ru.guk.education.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Service
public class HeaderService {

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
