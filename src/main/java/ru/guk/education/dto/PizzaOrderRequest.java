package ru.guk.education.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaOrderRequest {

    private String pizzaName;
    private Integer pizzaQuantity;

}
