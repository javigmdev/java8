package com.java.lambdas;

import java.util.Arrays;
import java.util.List;

public class Lambda_000_Introduction {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0,1,1,2,3,5,8,13,21,34,55);

        System.out.println("Example 1: For each");
        numbers.forEach(p -> System.out.print(p + ","));
        System.out.println("\n");

        System.out.println("Example 2: Lambda with multiple instructions");
        numbers.forEach(p -> {
            System.out.print(p + ",");
            System.out.print(p+1 + ",");
        });
        System.out.println("\n");

        /*
         *  Lambda final limitation:
         *      1. Variables used inside must be final
         *      2. If variables are not declared as final, the compiler does it automatically
         *      3. Cannot modify a final variable
         */
        System.out.println("Example 3: for each with accumulation is not allowed");
        final String separator = ",";
        //String aux = "";
        numbers.forEach(p -> {
            System.out.print(p + separator);
            //not working
            //aux += p.toString() + separator;
        });
        System.out.println("\n");

        /*
         * A lambda can return a parameter.
         * For example, the sort function requires the lambda to return an integer
         * value (compareTo).
         */
        System.out.println("Example 4: Returns params");
        numbers.sort((Integer e1, Integer e2) -> {
            return e1.compareTo(e2) * -1;
        });
        System.out.println(numbers + "\n");

        /*
         *  A lambda of a statement is returned without return (implicit return).
         */
        System.out.println("Example 5: Return params (implicit)");
        numbers.sort((e1, e2) -> e1.compareTo(e2));
        System.out.println(numbers + "\n");
    }
}
