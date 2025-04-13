package ru.guk.education.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidName {
    String message() default "Имя должно начинаться с заглавной буквы и содержать только буквы";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
