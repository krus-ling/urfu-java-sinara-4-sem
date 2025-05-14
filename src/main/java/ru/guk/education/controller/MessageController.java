package ru.guk.education.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.guk.education.dto.MessageDTO;
import ru.guk.education.service.ProducerService;

@AllArgsConstructor
@RestController
@RequestMapping("api/messages")
public class MessageController {

    private final ProducerService producerService;

    @PostMapping
    public ResponseEntity<String> send(@RequestBody MessageDTO message) {
        producerService.send(message);
        return ResponseEntity.ok("Message sent");
    }
}