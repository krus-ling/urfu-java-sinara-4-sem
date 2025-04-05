package ru.guk.education.injection;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.guk.education.service.MessageService;

/**
 * <b>DI через поле</b>
 */
@Service
@RequiredArgsConstructor
public class FieldInjectionService {

    private final MessageService emailService;

    public void process() {
        emailService.sendMessage("Сообщение через полевой DI");
    }
}
