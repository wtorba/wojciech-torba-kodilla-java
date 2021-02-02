package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TaskFactoryTestSuite {

    @Test
    void testShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task task = factory.makeTask(TaskFactory.SHOPPING);
        //Then
        assertTrue(task instanceof ShoppingTask);
        assertEquals("Shopping", task.getTaskName());
        assertFalse(task.isTaskExecuted());
    }

    @Test
    void testPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task task = factory.makeTask(TaskFactory.PAINTING);
        task.executeTask();
        //Then
        assertTrue(task instanceof PaintingTask);
        assertEquals("Painting", task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task task = factory.makeTask(TaskFactory.DRIVING);
        task.executeTask();
        //Then
        assertTrue(task instanceof DrivingTask);
        assertEquals("Driving", task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }
}
