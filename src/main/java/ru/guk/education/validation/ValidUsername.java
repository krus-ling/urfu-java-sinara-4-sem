package ru.guk.education.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@NotBlank
@Size(min = 3, max = 50)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUsername {
    String message() default "Имя пользователя должно быть от 3 до 50 символов и не пустым";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
