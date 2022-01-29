package com.java.lambdas;

import java.util.Arrays;
import java.util.stream.Stream;

public class Lambda_004_StaticMethods {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1,2,3,4);
        System.out.println("Example 1: method Stream.of");
        System.out.println(Arrays.toString(stream.toArray()));

        System.out.println("Example 2: ");
        FooIface foo = FooIface.caps();
        String name = foo.method("Jon", "William",27);
        System.out.println(name);

        System.out.println("Example 3: ");
        String name2 = FooIface.caps().method("Jon", 27);
        System.out.println(name2);
    }

    public static class Foo implements FooIface {
        @Override
        public String method(String name, Integer age) {
            return "Hello world! My name is " + name + " and I'm " + age + " years old";
        }
    }

    @FunctionalInterface
    public interface FooIface{
        String method(String name, Integer age);

        default String method(String name, String surname, Integer age){
            return method(name + " " + surname, age);
        }

        static FooIface caps() {
            return (String name, Integer age) -> name.toUpperCase();
        }
    }
}
