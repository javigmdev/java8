package com.java.optionals;

import java.util.Optional;

public class Optional_003_Default_Value {

    public static void main(String[] args) {
        System.out.println("orElse: return the wrapped value if it's present and its argument otherwise");
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("default value");
        System.out.println(name);

        System.out.println("orElseGet: similar to orElse, but if the Optional value is not present, it takes a supplier functional interface");
        name = Optional.ofNullable(nullName).orElseGet(() -> "default value");
        System.out.println(name);


        System.out.println("\nWhen the wrapped value is not present, then both  work exactly the same way.");
        String text = null;
        System.out.println("Using orElse:");
        String defaultTextElse = Optional.ofNullable(text).orElse(getMyDefault());
        System.out.println("Using orElseGet:");
        String defaultTextElseGet = Optional.ofNullable(text).orElseGet(() -> getMyDefault());

        System.out.println("\nWhen using orElse(), whether the wrapped value is present or not, the default object is created");
        System.out.println("When using orElseGet() to retrieve the wrapped value, the getMyDefault() method is not even invoked since the contained value is present");

        text = "text";
        System.out.println("Using orElse:");
        defaultTextElse = Optional.ofNullable(text).orElse(getMyDefault());
        System.out.println("Using orElseGet:");
        defaultTextElseGet = Optional.ofNullable(text).orElseGet(() -> getMyDefault());
    }

    public static String getMyDefault(){
        System.out.println("Getting Default Value");
        return "Default Value";
    }
}
