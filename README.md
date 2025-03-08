## ФИО: Гук Егор Михайлович
## Преподаватель: Карсканов Никита Андреевич

---

## Spring Boot Application

Аннотация `@SpringBootApplication` объединяет три ключевые аннотации Spring Boot:

- **`@SpringBootConfiguration`** – указывает, что класс является конфигурационным и может содержать определения бинов.
- **`@EnableAutoConfiguration`** – включает механизм автоматической конфигурации Spring Boot, который анализирует зависимости и настраивает приложение без необходимости явного определения бинов.
- **`@ComponentScan`** – активирует автоматическое сканирование компонентов (`@Component`, `@Service`, `@Repository`, `@Controller`) в текущем пакете и его подпакетах.

## Параметры аннотации `@SpringBootApplication`:

|   | Параметр                 | Описание                                                                                                                                                                                                                                                 |
|---|--------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | `exclude`                | Позволяет исключить определенные классы конфигурации из автоматической настройки. Принимает массив классов.                                                                                                                                              |
| 2 | `excludeName`            | Исключает классы по их полным именам (в виде строки), что удобно при работе с динамическими конфигурациями.                                                                                                                                              |
| 3 | `scanBasePackages`       | Определяет список пакетов, которые необходимо сканировать для поиска компонентов. Полезно, если бины находятся за пределами стандартного корневого пакета.                                                                                               |
| 4 | `scanBasePackageClasses` | Позволяет задать классы, из пакетов которых Spring будет начинать сканирование компонентов. Используется, если нужно указать конкретные точки входа в пакеты.                                                                                            |
| 5 | `nameGenerator`          | Класс `BeanNameGenerator`, используемый для именования компонентов.                                                                                                                                                                                      |
| 6 | `proxyBeanMethods`       | Включает (true) или отключает (false) проксирование методов внутри конфигурационного класса (@Configuration). При false Spring не создает прокси-объект, что ускоряет загрузку контекста, но запрещает вызов методов-конфигураций внутри того же класса. |

### Примеры:

#### 1. `exclude`:
```java
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

#### 2. `excludeName`:
```java
@SpringBootApplication(excludeName = {"org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

#### 3. `scanBasePackages`:
```java
@SpringBootApplication(scanBasePackages = {"com.example.service", "com.example.repository"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

#### 4. `scanBasePackageClasses`:
```java
@SpringBootApplication(scanBasePackageClasses = MyComponent.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

#### 5. `nameGenerator`:
```java
@SpringBootApplication(nameGenerator = CustomBeanNameGenerator.class)
public class CustomBeanNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        return "custom_" + definition.getBeanClassName();
    }
}
```

#### 6. `proxyBeanMethods`:
```java
@SpringBootApplication(proxyBeanMethods = false)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
# &#128521;