package ru.guk.education.eventListener;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.guk.education.eventListener.event.AppEvent;

@Log4j2
@Component
public class SimpleEventListener {

    @EventListener
    public void handle(AppEvent event) {
        log.info("💚 [Simple Listener] Обработано событие: {},", event.message());
    }
}