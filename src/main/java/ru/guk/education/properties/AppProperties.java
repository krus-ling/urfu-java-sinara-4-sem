package ru.guk.education.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "my-config")
public class AppProperties {

    private String name;
    private List<String> list;

}
