package ru.guk.education;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.guk.education.injection.ConstructorInjectionService;
import ru.guk.education.injection.FieldInjectionService;
import ru.guk.education.injection.SetterInjectionService;
import ru.guk.education.service.NotificationService;

@SpringBootApplication
public class EnvironmentApplication  implements CommandLineRunner {

    private final ConstructorInjectionService constructorService;
    private final FieldInjectionService fieldService;
    private final SetterInjectionService setterService;
    public final NotificationService notificationService;

    public EnvironmentApplication(NotificationService notificationService,
                                  SetterInjectionService setterService,
                                  ConstructorInjectionService constructorService,
                                  FieldInjectionService fieldService) {
        this.notificationService = notificationService;
        this.setterService = setterService;
        this.constructorService = constructorService;
        this.fieldService = fieldService;
    }


    public static void main(String[] args) {
        SpringApplication.run(EnvironmentApplication.class, args);
    }

    @Override
    public void run(String... args) {
        notificationService.notifyAllServices("Какое-то сообщение");
        constructorService.process();
        fieldService.process();
        setterService.process();
    }
}
