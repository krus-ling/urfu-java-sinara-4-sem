package ru.guk.education.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageSenderService {

    private final RabbitTemplate rabbitTemplate;
    private final Environment env;

    public MessageSenderService(final RabbitTemplate rabbitTemplate, final Environment env) {
        this.rabbitTemplate = rabbitTemplate;
        this.env = env;
    }

    public void send(Map<String, Object> message) {
        rabbitTemplate.convertAndSend(
                env.getProperty("app.exchange"),
                env.getProperty("app.routing-key"),
                message
        );
    }
}
