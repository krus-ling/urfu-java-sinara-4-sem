package ru.guk.education.metric;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.guk.education.service.PizzaOrderService;

@Component
@AllArgsConstructor
public class PizzaMetricCollector {

    private final PizzaOrderService pizzaOrderService;
    private final MeterRegistry meterRegistry;

    @PostConstruct
    public void init() {
        pizzaOrderService
                .getPizzaOrdersStats()
                .forEach( (pizzaName, pizzaQuantity) -> {
                    Gauge.builder("pizza_orders_total", () -> pizzaOrderService.getPizzaOrdersStats().getOrDefault(pizzaName, 0))
                            .tag("pizza_name", pizzaName)
                            .register(meterRegistry);
                });
    }
}
