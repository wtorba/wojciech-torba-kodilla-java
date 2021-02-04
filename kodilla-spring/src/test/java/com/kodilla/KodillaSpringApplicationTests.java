package com.kodilla;

import com.kodilla.spring.shape.Circle;
import com.kodilla.spring.shape.Shape;
import com.kodilla.spring.shape.Square;
import com.kodilla.spring.shape.Triangle;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
class KodillaSpringApplicationTests {

	@Disabled
	@Test
	void testSquareLoadedIntoContainer() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = context.getBean(Square.class);
		//When
		String name = shape.getShapeName();
		//Then
		assertEquals("This is a square.", name);
	}

	@Disabled
	@Test
	void testCircleLoadedIntoContainer() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = context.getBean(Circle.class);

		//When
		String name = shape.getShapeName();

		//Then
		assertEquals("This is a circle.", name);
	}

	@Disabled
	@Test
	void testTriangleLoadedIntoContainer() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = context.getBean(Triangle.class);

		//When
		String name = shape.getShapeName();

		//Then
		assertEquals("This is a triangle.", name);
	}

//	@Test
//	void contextLoads() {
//	}

	@Test
	void testCircleLoadedIntoContainer2() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape)context.getBean("circle");

		//When
		String name = shape.getShapeName();

		//Then
		assertEquals("This is a circle.", name);
	}

	@Test
	void testTriangleLoadedIntoContainer2() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape)context.getBean("triangle");

		//When
		String name = shape.getShapeName();

		//Then
		assertEquals("This is a triangle.", name);
	}

	@Disabled
	@Test
	void testSquareLoadedIntoContainer2() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape)context.getBean("createSquare"); //to jest metoda. A co, jesli kilka klas ma te sama metode?

		//When
		String name = shape.getShapeName();

		//Then
		assertEquals("This is a square.", name);
	}


	@Test
	void testShapeLoadedIntoContainer() {
		//Given
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape)context.getBean("chosenShape"); //to jest metoda. A co, jesli kilka klas ma te sama metode?

		//When
		String name = shape.getShapeName();

		//Then
		System.out.println("Chosen shape says: " + name);
	}
}
