package ru.guk.education.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ru.guk.education.properties.AppProperties;

import static ru.guk.education.common.Profile.TEST;

@Log4j2
@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class SomeConfig {

    @Bean
    @Profile(TEST)
    public String testProfileBean() {
        log.info("😶‍🌫️Create testProfileBean");
        return "testProfileBean";
    }

    @Bean
    @ConditionalOnBean(name = "testProfileBean")
    public String dependentBean() {
        log.info("👺Create dependentBean");
        return "dependentBean";
    }

    @Bean
    @ConditionalOnExpression("#{'${envVar}' != 'default'}")
    public String envBaseBean() {
        log.info("💥Create envBaseBean");
        return "envBaseBean";
    }
}
