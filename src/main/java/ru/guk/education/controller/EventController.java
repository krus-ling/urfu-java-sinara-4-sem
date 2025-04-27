package ru.guk.education.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.guk.education.service.EventService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @PostMapping("/default")
    public void defaultEvent() {
        eventService.publishSimpleEvent();
    }

    @PostMapping("/async")
    public void asyncEvent() {
        eventService.publishAsyncEvent();
    }

    @PostMapping("/transactionalS")
    public void transactionalSuccessEvent() {
        eventService.publishTransactionalEventSuccess();
    }

    @PostMapping("/transactionalF")
    public void transactionalFailEvent() {
        eventService.publishTransactionalEventFail();
    }
}
