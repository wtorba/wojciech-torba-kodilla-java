package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class WithHamPizzaOrderDecorator extends AbstractPizzaOrderDecorator{
    public WithHamPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(4));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", ham";
    }

    @Override
    public String getDescription() {
        return getIngredients() + super.getCrust();
    }
}
