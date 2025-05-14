package ru.guk.education.config;

import ru.guk.education.dto.MessageDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConsumerConfig {

    final KafkaProperties kafkaProperties;

    @Bean
    public ConsumerFactory<String, MessageDTO> consumerFactory() {

        var properties = kafkaProperties.buildConsumerProperties();

        var deserializer = new JsonDeserializer<>(MessageDTO.class, false);
        deserializer.addTrustedPackages("ru.guk.education.dto");


        return new DefaultKafkaConsumerFactory<>(properties, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MessageDTO> kafkaListenerContainerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, MessageDTO>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        return factory;
    }
}