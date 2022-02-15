package com.java.optionals;

import java.util.Optional;

public class Optional_002_Conditional_Action {

    public static void main(String[] args) {
        System.out.println("ifPresent: checks if the argument passed is null or not before going ahead to execute some code on it");
        Optional<String> optional = Optional.of("example");
        optional.ifPresent(string -> System.out.println(string.length()));
    }
}
