package com.java.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda_008_FunctionalInterfaceAdvanced {

    public static void main(String[] args) {

        List<Integer> fib = Arrays.asList(55,1,2,1,3,5,8,13,21,34,55);

        System.out.println("Example 1: Create a complex comparator more easily");
        Comparator<Integer> comparator = (Integer e1, Integer e2) -> {
            System.out.println(e1 + " vs " + e2);
            if(e1.equals(13))
                return -1;
            else
                return e1.compareTo(e2);
        };

        fib.sort(comparator);
        System.out.println(fib);

        System.out.println("Example 2: Adding the comparator in a different class");
        fib.sort(MyIntegerComparator::compare);
        System.out.println(fib);
    }

    interface MyIntegerComparator {
        static int compare(Integer e1, Integer e2) {
            if(e1.equals(34))
                return -1;
            else
                return e1.compareTo(e2);
        }
    }
}
