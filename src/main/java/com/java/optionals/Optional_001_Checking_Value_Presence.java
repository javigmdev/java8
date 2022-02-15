package com.java.optionals;

import java.util.Optional;

public class Optional_001_Checking_Value_Presence {

    public static void main(String[] args) {
        System.out.println("isPresent: returns true if the wrapped value is not null");
        String name = "Tom";
        Optional<String> optional = Optional.of(name);
        if(optional.isPresent()){
            System.out.println("Is present");
        }

        optional = Optional.ofNullable(null);
        if(!optional.isPresent()){
            System.out.println("Is not present");
        }

        System.out.println("isEmpty (Java 11): the opposite of method isPresent");
    }
}
