package ru.guk.education.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class PizzaOrderService {

    private final Map<String, Integer> pizzaOrders = new HashMap<>();

    public synchronized void addPizza(String pizzaName, Integer pizzaQuantity) {
        pizzaOrders.merge(pizzaName, pizzaQuantity, Integer::sum);
    };

    public synchronized Map<String, Integer> getPizzaOrdersStats() {
        return Collections.unmodifiableMap(pizzaOrders);
    }
}
