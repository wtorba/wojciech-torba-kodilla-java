package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ThickPizzaOrderDecorator extends AbstractPizzaOrderDecorator {

    public ThickPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getCrust() {
        return " on thick crust";
    }

    @Override
    public String getDescription() {
        return super.getIngredients() + getCrust();
    }
}
