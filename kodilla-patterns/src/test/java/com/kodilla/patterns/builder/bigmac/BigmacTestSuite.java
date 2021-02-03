package com.kodilla.patterns.builder.bigmac;

import com.kodilla.patterns.builder.bigmac.Bigmac;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient("Onion")
                .bun("With Sezame")
                .burgers(2)
                .sauce("Barbecue")
                .ingredient("Pickles")
                .ingredient("Cheese")
                .ingredient("Bacon")
                .burgers(3)
                .bun("Without Sezame")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        assertEquals(4, howManyIngredients);
    }
}