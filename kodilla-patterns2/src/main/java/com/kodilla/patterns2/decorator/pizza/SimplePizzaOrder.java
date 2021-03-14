package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SimplePizzaOrder implements PizzaOrder {

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(25.00);
    }

    @Override
    public String getIngredients() {
        return "Sauce and cheese";
    }

     @Override
     public String getCrust() {
        return " on traditional crust";
     }
    @Override
    public String getDescription() {
        return getIngredients() + getCrust();
    }
}
