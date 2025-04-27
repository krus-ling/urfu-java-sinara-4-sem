package ru.guk.education.eventListener;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import ru.guk.education.eventListener.event.AppEvent;

@Log4j2
@Component
public class AsyncEventListener {

    @EventListener
    @Async
    public void handleAsync(AppEvent event) {
        log.info("💙 [Async Listener] Обработано событие (в потоке: {}): {}",
                Thread.currentThread().getName(), event.message());
    }
}
