package ru.guk.education.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.guk.education.service.HeaderService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/headers")
public class HeaderController {

    private final HeaderService headerService;

    @GetMapping()
    public String showHeaders(HttpServletRequest request, Model model) {
        return headerService.showHeaders(request, model);
    }
}
