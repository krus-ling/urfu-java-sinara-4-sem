package ru.guk.education.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сервис, использующий оба MessageService (Email и Sms)
 */
@Log4j2
@Service
public class NotificationService {

    private final List<MessageService> messageServices;

    public NotificationService(List<MessageService> messageServices) {
        this.messageServices = messageServices;
    }

    public void notifyAllServices(String message) {
        log.info("🔔 Отправка сообщения через все сервисы:");
        for (MessageService service : messageServices) {
            service.sendMessage(message);
        }
    }
}