package ru.guk.education.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.guk.education.service.MessageSenderService;

import java.util.Map;

@RestController
@RequestMapping("/send")
public class MessageController {

    private final MessageSenderService messageSenderService;

    public MessageController(MessageSenderService messageSenderService) {
        this.messageSenderService = messageSenderService;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody Map<String, Object> message) {
        messageSenderService.send(message);
        return ResponseEntity.ok("Message sent");
    }
}
