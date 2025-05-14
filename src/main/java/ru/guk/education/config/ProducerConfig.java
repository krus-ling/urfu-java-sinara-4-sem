package ru.guk.education.config;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.annotation.EnableKafka;
import ru.guk.education.dto.MessageDTO;

@Configuration
@EnableKafka
public class ProducerConfig {

    final KafkaProperties kafkaProperties;

    public ProducerConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public ProducerFactory<String, MessageDTO> producerFactory() {
        var properties = kafkaProperties.buildProducerProperties();

        var serializer = new JsonSerializer<MessageDTO>();

        return new DefaultKafkaProducerFactory<>(properties, new StringSerializer(), serializer);
    }

    @Bean
    public KafkaTemplate<String, MessageDTO> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}