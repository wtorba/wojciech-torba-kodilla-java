package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        int resInt = Calculator.add(5, 3);
        if (resInt==8) {
            System.out.println("Calc adding OK");
        } else {
            System.out.println("Calc adding error");
        }

        resInt = Calculator.substract(5,3);
        if (resInt==2) {
            System.out.println("Calc substracting OK");
        } else {
            System.out.println("Calc substracting error");
        }
    }
}