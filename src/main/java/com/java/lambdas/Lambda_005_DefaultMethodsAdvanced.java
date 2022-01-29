package com.java.lambdas;

public class Lambda_005_DefaultMethodsAdvanced {

    public static void main(String[] args) {
        IntegerMath subtraction = (a,b) -> a - b;

        System.out.println("20 - 10 = " + apply(20, 10, subtraction));

        System.out.println("10 - 20 = " + apply(20, 10, subtraction.swap()));
        System.out.println(subtraction.swap().operation(20, 10));
        System.out.println(subtraction.swap(20, 10));
    }

    private static int apply(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    @FunctionalInterface
    interface IntegerMath {
        int operation(int a, int b);

        default IntegerMath swap() {
            return (a, b) -> operation(b, a);
        }

        default int swap(int a, int b) {
            return operation(b, a);
        }
    }
}
