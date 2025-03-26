package ru.guk.education.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * <b>Реализация интерфейса (Email)</b>
 * */
@Log4j2
@Component
public class EmailService implements MessageService {

    @PostConstruct
    public void init() {
        log.info("✅EmailService был создан!");
    }

    @PreDestroy
    public void destroy() {
        log.info("💥EmailService был уничтожен!");
    }

    @Override
    public void sendMessage(String message) {
        log.info("\uD83D\uDCE7Отправка Email: {}", message);
    }
}