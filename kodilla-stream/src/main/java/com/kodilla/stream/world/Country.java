package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {
    private final BigDecimal population;
    private final String countryName;

    public Country(final String countryName, final BigDecimal population) {
        this.population = population;
        this.countryName = countryName;
    }

    public final BigDecimal getPeopleQuantity() {
        return population;
    }
}
