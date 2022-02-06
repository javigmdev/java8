package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collections_018_Stream_Collectors_Calculating_Practice {

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

        Double averageAge = players.stream()
                .collect(Collectors.averagingInt(Player::getAge));
        System.out.println("Average age: " + averageAge);

        Double averageAgeStriker = players.stream()
                .filter(player -> Position.STRIKER.equals(player.getMainPosition()))
                .collect(Collectors.averagingInt(Player::getAge));
        System.out.println("Average age striker: " + averageAgeStriker);

        Map<Position, Double> mapAverageAgeByPosition = players.stream()
                .collect(Collectors.groupingBy(
                        Player::getMainPosition,
                        Collectors.averagingInt(Player::getAge)
                ));
        System.out.println("Map average age by position: " + mapAverageAgeByPosition);

        Integer sumAge = players.stream()
                .collect(Collectors.summingInt(Player::getAge));
        System.out.println("Sum age: "  + sumAge);

        Integer sumAgeStriker = players.stream()
                .filter(player -> Position.STRIKER.equals(player.getMainPosition()))
                .collect(Collectors.summingInt(Player::getAge));
        System.out.println("Sum age striker: "  + sumAgeStriker);

        Map<Position, Integer> mapSumAgeByPosition = players.stream()
                .collect(Collectors.groupingBy(
                        Player::getMainPosition,
                        Collectors.summingInt(Player::getAge)
                ));
        System.out.println("Map sum age by position: " + mapSumAgeByPosition);

        System.out.println("Max age by position: ");
        players.stream()
                .collect(Collectors.groupingBy(
                        Player::getMainPosition
                        , Collectors.maxBy(Player::compareTo)
                ))
                .forEach((key, value) -> System.out.println(key + " " + value));
    }
}
