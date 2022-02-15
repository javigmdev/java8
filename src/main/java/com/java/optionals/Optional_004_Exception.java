package com.java.optionals;

import java.util.Optional;

public class Optional_004_Exception {

    public static void main(String[] args) {
        System.out.println("orElseThrow: Instead of returning a default value when the wrapped value is not present, it throws an exception");
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
    }
}
