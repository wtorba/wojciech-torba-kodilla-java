package com.kodilla.spring.portfolio;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
 class BoardTestSuite {

    @Test
    void testRead() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().addTask( "Umyc zeby");
        board.getInProgressList().addTask( "Ubrac sie");
        board.getDoneList().addTask( "Wstac");

        //Then
        System.out.println("todolist " + board.getToDoList().getLatestTask());
        System.out.println("inprogresslist " + board.getInProgressList().getLatestTask());
        System.out.println("donelist " + board.getDoneList().getLatestTask());

        assertEquals("Umyc zeby", board.getToDoList().getLatestTask());
        assertEquals("Ubrac sie", board.getInProgressList().getLatestTask());
        assertEquals("Wstac", board.getDoneList().getLatestTask());

    }
}
