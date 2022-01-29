package com.java.lambdas;

public class Lambda_003_DefaultMethods {

    public static void main(String[] args) {
        FooIface foo = new Foo();
        System.out.println("Example 1: original interface (no surname) and original implementation");
        System.out.println(foo.method("Jon", 27));

        FooIfaceV2 foo2 = new FooV2();
        System.out.println("Example 2: adding default method");
        System.out.println(foo2.unimplementedMethod("Jon", 27));
        System.out.println(foo2.implementedMethod1("Jon", "William", 27));
    }

    /*
     * Example 1: original interface (no surname) and original implementation
     */
    public static class Foo implements FooIface {
        @Override
        public String method(String name, Integer age) {
            return "Hello world! My name is " + name + " and I'm " + age + " years old";
        }
    }

    @FunctionalInterface
    public interface FooIface {
        String method(String name, Integer age);
    }

    /*
     * Example 2: In the future, it's necessary to add a new functionality, for example the last name.
     * If there are many implementations of the FooIface, it would be a lot of work.
     *
     * How can new functionality be added without modify all implementations?
     * Adding a default method in the original interface.
     */
    public static class FooV2 implements FooIfaceV2{
        @Override
        public String unimplementedMethod(String name, Integer age) {
            return "Hello world! My name is " + name + " and I'm " + age + " years old";
        }
    }

    @FunctionalInterface
    public interface FooIfaceV2 {
        String unimplementedMethod(String name, Integer age);

        default String implementedMethod1(String name, String surname, Integer age) {
            return unimplementedMethod(name + " " + surname, age);
        }
    }
}
