package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Autowired
    private final Display display;

    public final Double add(double a, double b) {
        display.displayValue(a+b);
        return a+b;
    }

    public final Double sub(double a, double b) {
        display.displayValue(a-b);
        return a-b;
    }

    public final Double mul(double a, double b) {
        display.displayValue(a*b);
        return a*b;
    }

    public final Double div(double a, double b) {
        if (b!=0.0) {
            display.displayValue(a/b);
            return a/b;
        }
        return null;
    }
}
