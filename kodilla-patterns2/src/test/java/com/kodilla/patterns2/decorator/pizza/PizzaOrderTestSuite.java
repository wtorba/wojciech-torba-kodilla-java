package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaOrderTestSuite {

    @Test
    public void testMargheritaPizza() {
        // Given
        PizzaOrder pizzaOrder = new SimplePizzaOrder();
        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(25), calculatedCost);
        assertEquals("Sauce and cheese on traditional crust", pizzaDescription);
    }

    @Test
    public void testPeperoniPizza() {
        // Given
        PizzaOrder pizzaOrder = new SimplePizzaOrder();
        pizzaOrder = new WithPepperoniPizzaOrderDecorator(pizzaOrder);
        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(28), calculatedCost);
        assertEquals("Sauce and cheese, peperoni on traditional crust", pizzaDescription);
    }

    @Test
    public void testThinMargheritaPizza() {
        // Given
        PizzaOrder pizzaOrder = new SimplePizzaOrder();
        pizzaOrder = new ThinPizzaOrderDecorator(pizzaOrder);
        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(25), calculatedCost);
        assertEquals("Sauce and cheese on thin crust", pizzaDescription);
    }

    @Test
    public void testFullWypasPizza() {
        // Given
        PizzaOrder pizzaOrder = new SimplePizzaOrder();
        pizzaOrder = new WithHamPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new ThickPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new WithBlueCheesePizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new WithOlivesPizzaOrderDecorator(pizzaOrder);
        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(37), calculatedCost);
        assertEquals("Sauce and cheese, ham, blue cheese, olives on thick crust", pizzaDescription);
    }

    @Test
    public void testUndecidedCustomerPizza() {
        // Given
        PizzaOrder pizzaOrder = new SimplePizzaOrder();
        pizzaOrder = new WithHamPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new ThickPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new WithPepperoniPizzaOrderDecorator(pizzaOrder);
        pizzaOrder = new ThinPizzaOrderDecorator(pizzaOrder);
        // When
        BigDecimal calculatedCost = pizzaOrder.getCost();
        String pizzaDescription = pizzaOrder.getDescription();
        // Then
        assertEquals(new BigDecimal(32), calculatedCost);
        assertEquals("Sauce and cheese, ham, peperoni on thin crust", pizzaDescription);
    }


}
