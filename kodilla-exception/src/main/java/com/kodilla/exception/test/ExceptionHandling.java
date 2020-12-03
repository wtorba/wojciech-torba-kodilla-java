package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String args[]) {
        SecondChallenge secondChallenge = new SecondChallenge();
        double x;
        double y;
        x=2.0;
        y=2.0;
        try {
            String result = secondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            System.out.println("Dostaliśmy wyjonteczek");
        }
        finally {
                System.out.println("Kończymy");
        }
    }
}
