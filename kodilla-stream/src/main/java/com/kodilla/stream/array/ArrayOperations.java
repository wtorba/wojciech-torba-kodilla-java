package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        double avg;
        IntStream.range(0,numbers.length).map(n -> numbers[n]).forEach(System.out::println);
        avg = IntStream.range(0,numbers.length).map(n -> numbers[n]).average().getAsDouble();
        System.out.println(avg);
        return avg;
    }
}
