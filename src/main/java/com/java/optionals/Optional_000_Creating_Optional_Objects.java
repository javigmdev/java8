package com.java.optionals;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Optional_000_Creating_Optional_Objects {

    public static void main(String[] args) {
        System.out.println("Optional: provide a type-level solution for representing optional values instead of null references");

        System.out.println("Optional.isEmpty: create an empty Optional object");
        Optional<String> empty = Optional.empty();

        System.out.println("Optional.of: create an Optional with the specified value of the specified type (the argument passed to the of() can't be null)");
        Optional<String> optionalString = Optional.of("Example");

        System.out.println("Optional.ofNullable: the argument passed can be null");
        String nullable = null;
        Optional<String> optionalNullable = Optional.ofNullable(nullable);
    }
}
