package ru.guk.education.actuator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Endpoint(id = "logtime")
public class LoggingEndpoint {

    private static final Logger log = LoggerFactory.getLogger(LoggingEndpoint.class);

    @ReadOperation
    public String logTime() {
        String message = "Custom actuator endpoint вызван в " + LocalDateTime.now();
        log.info(message);
        return message;
    }
}
