package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryTestSuite {

    @Autowired
    private Library library;

    @Test
    public void testLoadFromDb2() {
        //Given
        //When
        library.loadFromDb();
        //Then
        //do nothing
    }

    @Test
    public void testSaveToDb2() {
        //Given
        //When
        library.saveToDb();
        //Then
        //do nothing
    }

    @Test
    void testContext() {
        //Given
        ApplicationContext context =
                //new AnnotationConfigApplicationContext(LibraryConfig.class);
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }

//    @Test
//    void testLoadFromDb() {
//        //Given
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Library library = context.getBean(Library.class);  //czy nadpisujemy library z klasy?
//
//        //When
//        library.loadFromDb();
//
//        //Then
//        //do nothing
//    }
//
//    @Test
//    void testSaveToDb() {
//        //Given
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext("com.kodilla.spring");
//        Library library = context.getBean(Library.class);
//
//        //When
//        library.saveToDb();
//
//        //Then
//        //do nothing
//    }
}