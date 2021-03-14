package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ThinPizzaOrderDecorator extends AbstractPizzaOrderDecorator {

    public ThinPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        if (" on thick crust".equals(super.getCrust())) {
            return super.getCost().subtract(new BigDecimal(3));
        }
        return super.getCost();
    }

    @Override
    public String getCrust() {
        return " on thin crust";
    }

    @Override
    public String getDescription() {
        return super.getIngredients() + getCrust();
    }
}
