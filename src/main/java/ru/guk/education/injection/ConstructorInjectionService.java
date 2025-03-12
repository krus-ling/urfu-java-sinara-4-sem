package ru.guk.education.injection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.guk.education.service.MessageService;

/**
 * <b>DI через конструктор</b>
 * */
@Service
public class ConstructorInjectionService {

    private final MessageService messageService;

    public ConstructorInjectionService(@Qualifier("emailService")MessageService messageService) {
        this.messageService = messageService;
    }

    public void process() {
        messageService.sendMessage("Сообщение через конструкторный DI");
    }
}