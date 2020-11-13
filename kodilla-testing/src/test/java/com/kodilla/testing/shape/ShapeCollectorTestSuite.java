package com.kodilla.testing.shape;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("TDD: ShapeCollector Test Suite ")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("ShapeCollector tests started.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("ShapeCollector tests finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Executing test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for managing figures collection")
    class TestCollectionManaging {

        @DisplayName("when add Figure to empty shapeCollector , " +
                "then first element in shapeCollector equals Figure")
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Triangle(3.0);
            boolean addResult;
            //When
            addResult=shapeCollector.addFigure(shape);

            //Then
            assertEquals(shape, shapeCollector.getFigure(0));
            assertTrue(addResult);
        }

        @DisplayName("when remove Figure to shapeCollector containing only Figure , " +
                "then shapeCollector is empty")
        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(3.0);
            boolean removeResult;

            //When
            shapeCollector.addFigure(shape);
            removeResult=shapeCollector.removeFigure(shape);

            //Then
            assertNotEquals(shape, shapeCollector.getFigure(0));
            assertNull(shapeCollector.showFigures());
            assertTrue(removeResult);
        }

        @DisplayName("when remove Figure from shapeCollector containing many instances of Figure , " +
                "then first occurrence of Figure removed from shapeCollector")
        @Test
        void testRemoveFigureOneFromMultiple() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape1 = new Square(7.0);
            Shape shape2 = new Triangle(9.0);
            boolean removeResult;

            //When
            shapeCollector.addFigure(shape1);
            shapeCollector.addFigure(shape2);
            shapeCollector.addFigure(shape1);
            shapeCollector.addFigure(shape1);
            removeResult=shapeCollector.removeFigure(shape1);

            //Then
            assertEquals(shape2, shapeCollector.getFigure(0));
            assertEquals(shape1, shapeCollector.getFigure(1));
            assertEquals(shape1, shapeCollector.getFigure(2));
            assertTrue(removeResult);
        }

        @DisplayName("when remove Figure from empty shapeCollector , " +
                "then result of removeFigure is false")
        @Test
        void testRemoveFigureFromEmpty() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(3.0);
            boolean removeResult;

            //When
            removeResult=shapeCollector.removeFigure(shape);

            //Then
            assertFalse(removeResult);
        }
    }

    @Nested
    @DisplayName("Tests for displaying figures")
    class TestGetters {

        @DisplayName("when get Nth Figure from ShapeCollector , " +
                "then result equals to Figure added as Nth")
        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape1 = new Rectangle(5.0);
            Shape shape2 = new Square(3.4);

            //When
            shapeCollector.addFigure(shape1);
            shapeCollector.addFigure(shape2);

            //Then
            assertEquals(shape1, shapeCollector.getFigure(0));
            assertEquals(shape2, shapeCollector.getFigure(1));
        }

        @DisplayName("when showFigures used , " +
                "then result equals semicolon separated list of Figures names")
        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape1 = new Rectangle(5.0);
            Shape shape2 = new Square(3.4);
            String expected = "rectangle;square";

            //When
            shapeCollector.addFigure(shape1);
            shapeCollector.addFigure(shape2);

            //Then
            assertEquals(expected, shapeCollector.showFigures());
        }

        @DisplayName("when showFigures used on empty ShapeCollector, " +
                "then result is null")
        @Test
        void testShowFiguresFromEmpty() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape1 = new Rectangle(5.0);

            //When
            shapeCollector.addFigure(shape1);
            shapeCollector.removeFigure(shape1);

            //Then
            assertNull(shapeCollector.showFigures());
        }
    }

}
