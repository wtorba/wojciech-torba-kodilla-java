package com.kodilla.exception.test;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondChallengeTestSuite {

    @Test
    void verifyXequals2() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when
        double x=2.0;
        double y=0.0;
        // then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(x,y));
    }

    @Test
    void verifyXBiggerThan2() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when
        double x=2.2;
        double y=0.0;
        // then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(x,y));
    }

    @Test
    void verifyXLesserThan1() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when
        double x=0.6;
        double y=0.0;
        // then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(x,y));
    }

    @Test
    void verifyXBetween2and1andYDiffThan1p5() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when
        double x=1.2;
        double y=0.0;
        // then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(x,y));
    }

    @Test
    void verifyYEquals1p5() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when
        double x=1.2;
        double y=1.5;
        // then
        assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(x,y));
    }

    @Test
    void verifyXEquals1() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();
        // when
        double x=1.0;
        double y=2.5;
        // then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(x,y));
    }


}
