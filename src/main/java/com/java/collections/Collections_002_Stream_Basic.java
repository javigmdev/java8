package com.java.collections;

import com.java.collections.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collections_002_Stream_Basic {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Hello World", "He", "Hello", "World");

        List<String> iterativeStyleList = new ArrayList<>();
        for (String value : list){
            if(value.startsWith("He")){
                if(value.length() > 3){
                    iterativeStyleList.add(value);
                }
            }
        }
        System.out.println("Iterative-style: " + iterativeStyleList);

        List<String> functionalStyleList = list.stream()
                .filter(value -> value.startsWith("He"))
                .filter(value -> value.length() > 3)
                .collect(Collectors.toList());
        System.out.println("Functional-style: " + functionalStyleList);

        List<Player> players = Arrays.asList(
                new Player("Beckham", 43),
                new Player("Kane", 30),
                new Player("Muller", 35)
        );
        List<String> namesPlayers = players.stream()
                .filter(player -> player.getAge() < 40)
                .map(player -> player.getName())
                .collect(Collectors.toList());
        System.out.println("Stream with a object list" + namesPlayers);
    }
}
