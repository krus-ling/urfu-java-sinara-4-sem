package ru.guk.education.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.guk.education.exception.ApiLimitException;

@Aspect
@Component
@Slf4j
public class ApiCallAspect {

    @Value("${api.max.calls}")
    private int maxApiCalls;

    private int currentApiCalls = 0;

    private static final String ERROR_MESSAGE = "Превышено максимальное количество запросов API (%d) 😡! Попробуйте позже 🥺";

    @Pointcut("execution(* ru.guk.education.controller.*.*(..))")
    public void apiMethods() {}

    @Before("apiMethods()")
    public void checkApiCalls() {
        if (currentApiCalls >= maxApiCalls) {
            log.warn("Превышен лимит вызова API; текущий — {}, максимум — {}", currentApiCalls + 1, maxApiCalls);
            throw new ApiLimitException(
                    ERROR_MESSAGE.formatted(maxApiCalls)
            );
        }

        currentApiCalls++;
    }
}
