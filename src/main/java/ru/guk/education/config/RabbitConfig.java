package ru.guk.education.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

@Configuration
@EnableRabbit
public class RabbitConfig {

    @Value("${app.queue}")
    private String queue;

    @Value("${app.exchange}")
    private String exchange;

    @Value("${app.routing-key}")
    private String routingKey;

    @Bean
    public Queue queue() {
        return new Queue(queue, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(routingKey);
    }
}
