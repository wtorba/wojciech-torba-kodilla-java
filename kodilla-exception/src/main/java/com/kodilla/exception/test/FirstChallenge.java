package com.kodilla.exception.test;

import static java.lang.Double.NaN;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        try {
            if (b == 0) {
                throw new ArithmeticException();
            }
            return a / b;
        }
        catch(ArithmeticException e) {
            System.out.println("Pamiętaj cholero, nie dziel przez zero");
            return NaN;
        }
        finally {
            System.out.println("Dziękujemy za skorzystanie z naszego kalkulatora"); //tego się nie spodziewałem, że NaN pojawi się po finally
        }
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        double result = firstChallenge.divide(3, 0);

        System.out.println(result);

    }
}