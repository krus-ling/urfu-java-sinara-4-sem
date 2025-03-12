package ru.guk.education.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * <b>Реализация интерфейса (SMS)</b>
 * */
@Component
public class SmsService implements MessageService{

    @PostConstruct
    public void init() {
        System.out.println("✅SmsService был создан");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("💥SmsService был уничтожен");
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("\uD83D\uDCF1Отправка SMS: " + message);
    }
}