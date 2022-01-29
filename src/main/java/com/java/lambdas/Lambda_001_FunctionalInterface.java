package com.java.lambdas;

public class Lambda_001_FunctionalInterface {

    public static void main(String[] args) {
        System.out.println("Example 1: hello world method");
        helloWorldMethod();

        /*
         * Really, foo is an interface
         */
        System.out.println("Example 2: Store a lambda in an object");
        Foo foo = () -> System.out.println("Hello world lambda");
        foo.method();

        System.out.println("Example 3: Use lambda function as parameter");
        useLambdaAsParameter(foo);

        System.out.println("Example 4: Lambda with two parameters");
        FooBar fooBar = (name, age) -> "Hello world! My name is " + name +" and I'm " + age + " years old";
        System.out.println(fooBar.method("Jon", 27));
    }

    private static void helloWorldMethod() {
        System.out.println("Hello world method");
    }

    /*
     * @FunctionalInterface is not mandatory, but it is highly recommended
     */
    @FunctionalInterface
    public interface Foo{
        void method();

        // Two methods are not allowed
        // String method2(String a);
    }

    private static void useLambdaAsParameter(Foo foo){
        foo.method();
    }

    @FunctionalInterface
    public interface FooBar {
        String method(String name, Integer age);
    }
}
