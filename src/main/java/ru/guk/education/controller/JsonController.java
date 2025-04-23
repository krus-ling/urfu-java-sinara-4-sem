package ru.guk.education.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.guk.education.model.RequestData;
import ru.guk.education.service.JsonService;


@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
public class JsonController {

    private final JsonService jsonService;

    @PostMapping()
    public RequestData processJson(@RequestBody RequestData requestData) {
        return jsonService.processJson(requestData);
    }
}
