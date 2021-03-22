package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkTestSuite {

    @Test
    public void testUpdate() {
        // Given
        Homework kowalskiHomework = new Homework("Kowalski");
        Homework adamskiHomework = new Homework("Adamski");
        Homework kwiatkowskaHomework = new Homework("Kwiatkowska");
        Mentor mRyndak = new Mentor("Mateusz Ryndak");
        Mentor kLikus= new Mentor("Karol Likus");
        kowalskiHomework.registerObserver(mRyndak);
        adamskiHomework.registerObserver(kLikus);
        kwiatkowskaHomework.registerObserver(mRyndak);
        // When
        kowalskiHomework.addHomework("Homework 14.4");
        adamskiHomework.addHomework("Homework 15.1");
        kwiatkowskaHomework.addHomework("Homework 20.1");
        kowalskiHomework.addHomework("Homework 16.1");
        adamskiHomework.addHomework("Homework 15.2");
        // Then
        assertEquals(3, mRyndak.getUpdateCount());
        assertEquals(2, kLikus.getUpdateCount());
    }
}