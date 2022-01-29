package com.java.lambdas;

public class Lambda_002_Calculator {

    @FunctionalInterface
    interface IntegerMath {
        int operation(int a, int b);
    }

    public static void main(String[] args) {
        /*
         * Defining operations
         */
        IntegerMath addition = new IntegerMath() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };
        IntegerMath subtraction = (a, b) -> {
            return a - b;
        };
        IntegerMath multi = (a, b) -> a * b;
        IntegerMath division = (a, b) -> a / b;
        IntegerMath rest = (a, b) -> a % b;

        System.out.println("Applying operations: POO");
        System.out.println("40 + 2 = " + addition.operation(40,2));
        System.out.println("20 - 10 = " + subtraction.operation(20, 10));

        System.out.println("Applying operations: functional programming");
        System.out.println("40 + 2 = " + apply(40, 2, addition));
        System.out.println("20 - 10 = " + apply(20, 10, subtraction));
        System.out.println("20 * 10 = " + apply(20, 10, multi));
        System.out.println("20 / 10 = " + apply(20, 10, division));
        System.out.println("20 % 10 = " + apply(20, 10, rest));
    }

    private static int apply(int a, int b, IntegerMath op){
        return op.operation(a, b);
    }
}
