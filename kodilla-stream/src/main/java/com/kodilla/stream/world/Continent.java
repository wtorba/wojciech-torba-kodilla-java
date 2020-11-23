package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final List<Country> countries;

    public Continent(final List<Country> countries) {
        this.countries = countries;
    }

    public final List<Country> getCountries() {
        return new ArrayList<>(countries);
    }
}
