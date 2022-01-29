package com.java.lambdas;

import java.util.Arrays;
import java.util.List;

public class Lambda_006_MethodReferences {
    public static void main(String[] args) {
        List<Integer> fib = Arrays.asList(55,1,2,1,3,5,8,13,21,34,55);

        System.out.println("The :: operator is a lambda itself");
        System.out.println("Example 1: println");
        fib.forEach(System.out::print);
        System.out.println();

        fib.sort((e1, e2) -> e1.compareTo(e2));
        fib.sort(Integer::compareTo);
        System.out.println("Example 2: compareTo");
        System.out.println(fib);

        IntegerParser parser = Integer::parseInt;
        int value = parser.apply("8");

        System.out.println("Example 3: parseInt");
        System.out.println("Value: " + value);
        System.out.println("Value can be operable: " + value * 2);
    }

    @FunctionalInterface
    interface IntegerParser {
        int apply(String integer);
    }
}
