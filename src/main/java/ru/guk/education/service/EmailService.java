package ru.guk.education.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * <b>Реализация интерфейса (Email)</b>
 * */
@Component
public class EmailService implements MessageService {

    @PostConstruct
    public void init() {
        System.out.println("✅EmailService был создан!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("💥EmailService был уничтожен!");
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("\uD83D\uDCE7Отправка Email: " + message);
    }
}