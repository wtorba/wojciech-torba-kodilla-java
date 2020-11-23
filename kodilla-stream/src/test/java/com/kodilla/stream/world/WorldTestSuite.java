package com.kodilla.stream.world;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {


    @Test
    void testGetPeopleQuantity() {
        //Given
        Country c1 = new Country ("Polska", new BigDecimal("39000000"));
        Country c2 = new Country ("Niemcy", new BigDecimal("43000000"));
        Country c3 = new Country ("Japonia", new BigDecimal("24000000"));
        Country c4 = new Country ("Chiny", new BigDecimal("1500000000"));
        Country c5 = new Country("Indie", new BigDecimal("1250000000"));
        Country c6 = new Country("Kanada", new BigDecimal("50000000"));
        Country c7 = new Country("USA", new BigDecimal("254000000"));
        List<Country> EuropeList = new ArrayList<>();
        EuropeList.add(c1);
        EuropeList.add(c2);
        List<Country> AsiaList = new ArrayList<>(Arrays.asList(c3, c4, c5));
        List<Country> NorthAmericaList = new ArrayList<>(Arrays.asList(c6, c7));
        Continent europe = new Continent(EuropeList);
        Continent asia = new Continent(AsiaList);
        Continent northAmerica = new Continent(NorthAmericaList);
        List<Continent> worldList = new ArrayList<>(Arrays.asList(europe, asia, northAmerica));
        World world = new World(worldList);

        //When
        BigDecimal totalPeopleQuantity = world.getPeopleQuantity();

        //Then
        BigDecimal expectedSand = new BigDecimal("3160000000");
        assertEquals(expectedSand,totalPeopleQuantity);
    }
}
