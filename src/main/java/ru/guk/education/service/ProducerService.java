package ru.guk.education.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.guk.education.dto.MessageDTO;

@Service
@AllArgsConstructor
public class ProducerService {

    private final KafkaTemplate <String, MessageDTO> kafkaTemplate;

    public void send(MessageDTO message) {
        kafkaTemplate.send("sender", message);
    }
}
