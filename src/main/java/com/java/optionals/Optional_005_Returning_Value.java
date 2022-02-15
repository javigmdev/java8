package com.java.optionals;

import java.util.Optional;

public class Optional_005_Returning_Value {

    public static void main(String[] args) {
        System.out.println("get: retrieve the wrapped value");
        Optional<String> optional = Optional.of("value");
        System.out.println(optional.get());
    }
}
