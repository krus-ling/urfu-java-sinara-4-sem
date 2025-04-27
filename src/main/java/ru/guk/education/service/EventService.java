package ru.guk.education.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.guk.education.eventListener.event.AppEvent;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class EventService {

    private final ApplicationEventPublisher eventPublisher;

    public void publishSimpleEvent() {
        log.info("Публикация обычного события");
        eventPublisher.publishEvent(new AppEvent("Simple Event"));
    }

    public void publishAsyncEvent() {
        log.info("Публикация асинхронного события");
        eventPublisher.publishEvent(new AppEvent("Async Event"));
    }

    @Transactional
    public void  publishTransactionalEventSuccess() {
        log.info("Публикация успешного транзакционного события");
        eventPublisher.publishEvent(new AppEvent("Transaction Event Success"));
    }

    @Transactional
    public void  publishTransactionalEventFail() {
        try {
            log.info("Публикация НЕуспешного транзакционного события");
            eventPublisher.publishEvent(new AppEvent("Transaction Event Fail"));
            throw new RuntimeException("Искусственная ошибка для отката транзакции");
        } catch (Exception e) {
            log.error("Ошибка при получении события: {}", e.getMessage());
            throw e;
        }
    }
}
