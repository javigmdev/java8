package com.java.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Collections_001_Stream {

    public static void main(String[] args) {

        /*
         * Direct stream
         */
        Stream<String> stream = Stream.of("Hello", "World");

        /*
         * Stream from Collection
         */
        List<String> list = Arrays.asList("Hello", "World");
        Stream<String> listStream = list.stream();

        Set<String> set = new HashSet<>(list);
        Stream<String> setStream = set.stream();
    }
}
