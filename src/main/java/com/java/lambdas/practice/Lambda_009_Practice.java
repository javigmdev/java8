package com.java.lambdas.practice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda_009_Practice {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("William",25),
                new Person("Tom",50),
                new Person("Jack",35));

        printPersonOlderThan(persons, 40);
        printPersonBetweenTwoAgesAndStartingWith(persons, 20, 60, "Will");
        printPersonBetweenTwoAgesAndStartingWithFilter(persons, new PersonFilter(20, 60, "Will"));

        Predicate<Person> predicate = (Person p) -> (p.getAge() > 33 && p.getAge() < 45);
        printPerson(persons, predicate);

        Consumer<Person> consumer = Person::print;
        printPerson(persons, predicate, consumer);

        Function<Person, String> function = Person::getName;
        Consumer<String> consumerName = System.out::println;
        printPersonName(persons, predicate, function, consumerName);

        printPersonInfoGeneric(persons, predicate,
                Person::getName,
                System.out::println);

        printPersonInfoGeneric(persons, predicate,
                (Person p) -> p.getAge().toString(),
                System.out::println);
    }

    private static void printPersonOlderThan(List<Person> persons, int age) {
        System.out.println("Exercise 1: print person older than " + age);
        for (Person p : persons) {
            if(p.getAge() >= age){
                p.print();
            }
        }
    }

    private static void printPersonBetweenTwoAgesAndStartingWith(List<Person> persons, int minAge, int maxAge, String partialName) {
        System.out.println("Exercise 2: print persons between " + minAge + " and " + maxAge + " and starting with " + partialName);
        for (Person person : persons) {
            if(person.getAge() > minAge
                    && person.getAge() < maxAge
                    && person.getName().contains(partialName)){
                person.print();
            }
        }
    }

    private static void printPersonBetweenTwoAgesAndStartingWithFilter(List<Person> persons, PersonFilter filter){
        System.out.println("Exercise 3: exercise 2 with filter");
        for (Person person : persons) {
            if(filter.test(person)){
                person.print();
            }
        }
    }

    private static void printPerson(List<Person> persons, Predicate<Person> predicate){
        System.out.println("Exercise 4: print with predicate");
        for (Person person: persons) {
            if(predicate.test(person)){
                person.print();
            }
        }
    }

    private static void printPerson(List<Person> persons, Predicate<Person> predicate, Consumer<Person> action){
        System.out.println("Exercise 5: print with predicate and consumer");
        for (Person person : persons) {
            if(predicate.test(person)){
                action.accept(person);
            }
        }
    }

    private static void printPersonName(List<Person> persons, Predicate<Person> predicate, Function<Person, String> function, Consumer<String> consumer){
        System.out.println("Exercise 6: print name");
        for (Person person : persons) {
            if(predicate.test(person)) {
                String name = function.apply(person);
                consumer.accept(name);
            }
        }
    }

    private static<T> void printPersonInfoGeneric(Collection<T> genericList, Predicate<T> predicate, Function<T, String> function, Consumer<String> consumer){
        System.out.println("Exercise 7: print info with generic");
        for(T genericObject : genericList){
            if(predicate.test(genericObject)){
                String name = function.apply(genericObject);
                consumer.accept(name);
            }
        }
    }
}
