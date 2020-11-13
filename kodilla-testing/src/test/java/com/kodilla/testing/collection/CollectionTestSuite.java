package com.kodilla.testing.collection;


import org.junit.jupiter.api.*;
import java.util.*;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Collection Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Collection Test Suite: end");
    }

    @DisplayName("when create emptyList " +
                 "then exterminate should return empty list")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> result = OddNumbersExterminator.exterminate(emptyList);
        System.out.println("result.size: " + result.size());
        //Then
        Assertions.assertEquals(0, result.size());
    }

    @DisplayName("when create List with odds and evens " +
                 "then exterminate should return list of evens only")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> normalList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> expectedList = Arrays.asList(2, 4, 6);
        //When
        List<Integer> result = OddNumbersExterminator.exterminate(normalList);
        System.out.println("result size: " + result.size());
        System.out.println("result content: " + result);
        //Then
        Assertions.assertEquals(expectedList.size(), result.size());
        Assertions.assertEquals(expectedList, result);
    }
}