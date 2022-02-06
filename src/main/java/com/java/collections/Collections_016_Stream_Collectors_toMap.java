package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;


import java.util.*;
import java.util.stream.Collectors;

public class Collections_016_Stream_Collectors_toMap {

    public static void main(String[] args) {
        List<Player> players = Arrays.asList(
                new Player("William",48, Position.GOALKEEPER),
                new Player("Muller",60, Position.GOALKEEPER),
                new Player("Kane",25, Position.GOALKEEPER),
                new Player("Gerard",48, Position.DEFENDER),
                new Player("Rooney",69, Position.DEFENDER),
                new Player("Cooper",29, Position.DEFENDER),
                new Player("Cole",25, Position.MIDFIELDER),
                new Player("Bloomer",50, Position.MIDFIELDER),
                new Player("Stiles",35, Position.MIDFIELDER),
                new Player("Butt",20, Position.MIDFIELDER),
                new Player("Byrne",31, Position.STRIKER),
                new Player("Barnes",50, Position.STRIKER),
                new Player("Ferguson",42, Position.STRIKER),
                new Player("Moore", 27, Position.SOCCER_FAN),
                new Player("Charlton", 88, Position.SOCCER_FAN),
                new Player("Rowe", 96, Position.SOCCER_FAN));

        System.out.println("Collectors toMap: is used to collect Streams into a Map instance");
        Map<String, Player> mapPlayersByName = players.stream()
                .collect(Collectors.toMap(Player::getName, player -> player));
        System.out.println("Players by name: "+ mapPlayersByName);

        List<Player> players2 = Arrays.asList(
                new Player("William",48),
                new Player("Kane",60),
                new Player("Kane",25));
        Map<String, Player> mapPlayersByNameOrderByAgeDesc = players2.stream()
                .collect(Collectors.toMap(
                        Player::getName,
                        player -> player,
                        (player1, player2) -> player1.getAge() >= player2.getAge() ? player1 : player2
                        //Player::eldest
                ));
        System.out.println("Players by name order by age desc: " + mapPlayersByNameOrderByAgeDesc);

        HashMap<String, Player> playerHashMap = players2.stream()
                .collect(Collectors.toMap(
                        Player::getName,
                        player -> player,
                        (player1, player2) -> player1,
                        HashMap::new
                ));
        System.out.println("Map to hashMap: " + playerHashMap);

        TreeMap<String, Player> playerTreeMap = players2.stream()
                .collect(Collectors.toMap(
                        Player::getName,
                        player -> player,
                        (player1, player2) -> player2,
                        TreeMap::new
                ));
        System.out.println("Map to treeMap: " + playerTreeMap);

        System.out.println("\nCollectors groupingBy: is used for grouping objects by some property and storing results in a Map instance");
        Map<Position, List<Player>> mapPlayersByPosition = players.stream()
                .collect(Collectors.groupingBy(Player::getMainPosition));

        mapPlayersByPosition.forEach((position, listPlayers) -> {
            int sum = listPlayers.stream()
                    .mapToInt(Player::getAge)
                    .sum();
            System.out.println("Sum ages by position " + position + ": " + sum);
        });

        Map<Integer, Long> countByAge = players.stream()
                .collect(Collectors.groupingBy(
                        Player::getAge,
                        Collectors.counting()
                ));
        System.out.println("Count by age: " + countByAge);

        Map<Position, Double> averageByPosition = players.stream()
                .collect(Collectors.groupingBy(
                        Player::getMainPosition,
                        Collectors.averagingInt(Player::getAge)
                ));
        System.out.println("Average by position: " + averageByPosition);

        Map<Integer, Set<Player>> playersByAge = players.stream()
                .collect(Collectors.groupingBy(Player::getAge, Collectors.toSet()));
        System.out.println("Players by age: " + playersByAge);

        System.out.println("\nCollectors partitioning: returns a Collector that partitions the input elements according to a Predicate");
        Map<Boolean, List<Player>> playersOlderThan50 = players.stream()
                .collect(Collectors.partitioningBy(player -> player.getAge() > 50));
        System.out.println("Older than 50: " + playersOlderThan50);
        System.out.println("Number players > 50: " + playersOlderThan50.get(true).size());
        System.out.println("Number players < 50: " + playersOlderThan50.get(false).size());

        Map<Boolean, Set<String>> namesOlderThan35 = players.stream()
                .collect(Collectors.partitioningBy(
                        player -> player.getAge() > 35,
                        Collectors.mapping(Player::getName, Collectors.toSet())
                ));
        System.out.println("Older than 35: " + namesOlderThan35);
        System.out.println("Number names players > 35: " + namesOlderThan35.get(true).size());
        System.out.println("Number names players < 35: " + namesOlderThan35.get(false).size());
    }
}
