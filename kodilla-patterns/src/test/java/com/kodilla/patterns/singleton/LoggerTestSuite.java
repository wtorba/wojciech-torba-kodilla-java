package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void openLog() {
        logger = Logger.INSTANCE;
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        logger.log("Siabadabada");
        logger.log("Jabadabadu!");
        String result = logger.getLastLog();
        //Then
        assertEquals("Jabadabadu!", result);
    }

}
