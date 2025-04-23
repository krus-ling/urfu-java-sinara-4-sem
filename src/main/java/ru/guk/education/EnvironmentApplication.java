package ru.guk.education;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.guk.education.injection.ConstructorInjectionService;
import ru.guk.education.injection.FieldInjectionService;
import ru.guk.education.injection.SetterInjectionService;
import ru.guk.education.service.NotificationService;

@SpringBootApplication
@Log4j2
@RequiredArgsConstructor
public class EnvironmentApplication  implements CommandLineRunner {

    private final ConstructorInjectionService constructorService;
    private final FieldInjectionService fieldService;
    private final SetterInjectionService setterService;
    public final NotificationService notificationService;


    public static void main(String[] args) {
        SpringApplication.run(EnvironmentApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Starting application logic...🎇");
        notifyAllServices();
        demonstrateInjections();
    }

    private void notifyAllServices() {
        notificationService.notifyAllServices("Какое-то сообщение");
    }

    private void demonstrateInjections() {
        constructorService.process();
        fieldService.process();
        setterService.process();
    }
}
