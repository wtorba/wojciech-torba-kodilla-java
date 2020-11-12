package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {
    public static List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();
        for(Integer elem : numbers) {
            if (elem % 2 == 0) {
                evenNumbers.add(elem);
            }
        }
        return evenNumbers;
    }
}
