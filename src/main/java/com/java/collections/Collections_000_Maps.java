package com.java.collections;

import java.util.HashMap;
import java.util.Map;

public class Collections_000_Maps {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("John", "Travolta");

        map.putIfAbsent("John", "Wilson");
        System.out.println("Example putIfAbsent: inserts the specified value/key if the specified key is already not present in the hashmap");
        System.out.println(map);

        System.out.println("Example compute: computes a new value and associates it with the specified key in the hashmap");
        map.compute("John", (key, value) -> "Brown");
        System.out.println(map);

        Map<String, String> map2 = new HashMap<>();
        map2.putIfAbsent("Harry", "Jackson");
        map2.putIfAbsent("David", "Jobs");
        map2.putIfAbsent("John", "Morrison");

        Map<String, String> map3 = new HashMap<>(map);
        System.out.println("Example merge: inserts the specified key/value mapping to the hashmap");
        System.out.println("If the specified key is already associated with a value, it replaces the old value with the result of the specified function");
        map2.forEach((key, value) -> map3.merge(key, value, (oldValue, newValue) -> oldValue));
        System.out.println(map3);
        map2.forEach((key, value) -> map3.merge(key, value, (oldValue, newValue) -> newValue));
        System.out.println(map3);
    }
}
