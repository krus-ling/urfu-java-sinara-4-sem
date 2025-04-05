package ru.guk.education.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.guk.education.service.MessageService;

/**
 * <b>DI через поле</b>
 */
@Service
public class FieldInjectionService {

    private final MessageService emailService;

    public FieldInjectionService(MessageService emailService) {
        this.emailService = emailService;
    }

    public void process() {
        emailService.sendMessage("Сообщение через полевой DI");
    }
}
