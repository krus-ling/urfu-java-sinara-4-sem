package ru.guk.education.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.guk.education.dto.PizzaOrderRequest;
import ru.guk.education.service.PizzaOrderService;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/pizza")
@AllArgsConstructor
public class PizzaOrderController {

    private final PizzaOrderService pizzaOrderService;

    @PostMapping
    public String orderPizza(@RequestBody PizzaOrderRequest request) {
        pizzaOrderService.addPizza(request.getPizzaName(), request.getPizzaQuantity());
        return "Pizza Order Submitted";
    }

    @GetMapping("/stats")
    public Map<String, Integer> getStats() {
        return pizzaOrderService.getPizzaOrdersStats();
    }
}
