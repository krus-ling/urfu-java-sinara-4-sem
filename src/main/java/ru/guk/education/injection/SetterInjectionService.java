package ru.guk.education.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.guk.education.service.MessageService;

/**
 * <b>DI через сеттер</b>
 * */
@Service
public class SetterInjectionService {

    private MessageService messageService;

    @Autowired
    public void setMessageService(MessageService smsService) {
        this.messageService = smsService;
    }

    public void process() {
        messageService.sendMessage("Сообщение через setter DI");
    }
}
