package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class WithBlueCheesePizzaOrderDecorator extends AbstractPizzaOrderDecorator{
    public WithBlueCheesePizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", blue cheese";
    }

    @Override
    public String getDescription() {
        return getIngredients() + super.getCrust();
    }
}
