package ru.guk.education;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.guk.education.injection.ConstructorInjectionService;
import ru.guk.education.injection.FieldInjectionService;
import ru.guk.education.injection.SetterInjectionService;

@SpringBootApplication
public class EnvironmentApplication  implements CommandLineRunner {

    private final ConstructorInjectionService constructorService;
    private final FieldInjectionService fieldService;
    private final SetterInjectionService setterService;

    public EnvironmentApplication(ConstructorInjectionService constructorService,
                                  FieldInjectionService fieldService,
                                  SetterInjectionService setterService) {

        this.constructorService = constructorService;
        this.fieldService = fieldService;
        this.setterService = setterService;
    }


    public static void main(String[] args) {
        SpringApplication.run(EnvironmentApplication.class, args);
    }

    @Override
    public void run(String... args) {
        constructorService.process();
        fieldService.process();
        setterService.process();
    }
}
