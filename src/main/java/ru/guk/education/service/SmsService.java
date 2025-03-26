package ru.guk.education.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * <b>Реализация интерфейса (SMS)</b>
 * */
@Log4j2
@Component
public class SmsService implements MessageService{

    @PostConstruct
    public void init() {
        log.info("✅SmsService был создан");
    }

    @PreDestroy
    public void destroy() {
        log.info("💥SmsService был уничтожен");
    }

    @Override
    public void sendMessage(String message) {
        log.info("\uD83D\uDCF1Отправка SMS: {}", message);
    }
}