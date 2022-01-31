package com.java.collections;

import java.util.Arrays;
import java.util.List;

public class Collections_011_Stream_Reduce {

    /**
     * Reduce: produce one single result from a sequence of elements
     *
     * The key concepts:
     * Identity: an element that is the initial value of the reduction operation and the default result if the stream
     *           is empty
     * Accumulator: a function that takes two parameters (a partial result of the reduction operation and the next
     *              element of the stream)
     * Combiner: a function used to combine the partial result of the reduction operation when the reduction is
     *           parallelized or when there's a mismatch between the types of the accumulator arguments and the types
     *           of the accumulator implementation
     */

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4);

        int result = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element);
        System.out.println("Example reduce 1: " + result);

        int result2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Example reduce 2: " + result2);

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result3 = letters.stream().reduce("", (partialString, element) -> partialString + element);
        System.out.println("Example reduce 3: " + result3);

        String result4 = letters.stream().reduce("", String::concat);
        System.out.println("Example reduce 4: " + result4);

        String result5 = letters.stream().reduce("", (e1,e2) -> e1 + "_" +e2, (c1, c2) -> c1.toUpperCase()+c2);
        System.out.println("Example reduce 5: "+result5);
    }
}
