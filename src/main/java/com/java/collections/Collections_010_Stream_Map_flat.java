package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Collections_010_Stream_Map_flat {

    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("1","2"),
            Arrays.asList("3","4")
        );
        System.out.println("Original list: " + listOfLists);

        List<String> simpleList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Simple list: " + simpleList);

        System.out.println("Flat map with list of object:");
        List<Player> players = Arrays.asList(
                new Player("Rooney", 48, Position.STRIKER,
                        Arrays.asList(Position.STRIKER, Position.MIDFIELDER)),
                new Player("Gerard", 60, Position.STRIKER,
                        Arrays.asList(Position.STRIKER, Position.DEFENDER)),
                new Player("Byrne", 25, Position.STRIKER,
                        Arrays.asList(Position.STRIKER, Position.GOALKEEPER))
        );
        players.stream()
                .flatMap(player -> player.getAlternativePositions().stream())
                .flatMap(position -> position.positions.stream())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        List<List<Integer>> listOfListsIntegers = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(11, 12));
        IntStream intStream = listOfListsIntegers.stream()
                .flatMapToInt(list -> list.stream().mapToInt(number -> number));
        System.out.println("Summary statistics: " + intStream.summaryStatistics());
    }
}
