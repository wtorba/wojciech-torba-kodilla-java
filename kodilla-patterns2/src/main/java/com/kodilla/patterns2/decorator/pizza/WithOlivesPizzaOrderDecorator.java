package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class WithOlivesPizzaOrderDecorator extends AbstractPizzaOrderDecorator{
    public WithOlivesPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(2));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", olives";
    }

    @Override
    public String getDescription() {
        return getIngredients() + super.getCrust();
    }
}
