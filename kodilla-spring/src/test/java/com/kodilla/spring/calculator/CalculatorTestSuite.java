package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations() {
        //Given
        Double result;
        //When
        result = calculator.add(1.0, 2.0);
        //Then
        assertEquals(3.0, result);

        //When
        result = calculator.sub(1.0, 2.0);
        //Then
        assertEquals(-1.0, result);

        //When
        result = calculator.mul(3.0, 0.5);
        //Then
        assertEquals(1.5, result);

        //When
        result = calculator.div(6.0, 2.0);
        //Then
        assertEquals(3.0, result);

        //When
        result = calculator.div(1.0, 0.0);
        //Then
        assertNull(result);

    }

}
