package ru.guk.education.injection;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.guk.education.service.MessageService;

/**
 * <b>DI через конструктор</b>
 * */
@Service
@RequiredArgsConstructor
public class ConstructorInjectionService {

    private final MessageService emailService;

    public void process() {
        emailService.sendMessage("Сообщение через конструкторный DI");
    }
}