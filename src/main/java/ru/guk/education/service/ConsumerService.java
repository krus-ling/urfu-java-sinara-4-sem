package ru.guk.education.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.guk.education.dto.MessageDTO;

@Log4j2
@Service
public class ConsumerService {

    @KafkaListener(topics = "sender", groupId = "my-group", containerFactory = "kafkaListenerContainerFactory")
    public void listen(MessageDTO message) {
        log.info("Message received: {}", message);
    }
}
