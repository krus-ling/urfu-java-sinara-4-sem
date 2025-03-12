package ru.guk.education.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.guk.education.service.MessageService;

/**
 * <b>DI через поле</b>
 * */
@Service
public class FieldInjectionService {

    @Autowired
    @Qualifier("emailService")
    private MessageService messageService;

    public void process() {
        messageService.sendMessage("Сообщение через полевой DI");
    }
}
