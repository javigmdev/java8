package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collections_003_Stream_Usage {

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

        System.out.println("Name of players whose age is between 20 and 35:");
        players.stream()
                .filter(player -> player.getAge() >= 20)
                .filter(player -> player.getAge() <= 35)
                .map(Player::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nName of players whose age is between 20 and 35 and their position is midfielder:");
        players.stream()
                .filter(player -> player.getAge() >= 20)
                .filter(player -> player.getAge() <= 35)
                .filter(player -> player.getMainPosition().equals(Position.MIDFIELDER))
                .map(Player::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        long count = players.stream()
                .filter(player -> !player.getMainPosition().equals(Position.STRIKER))
                .filter(player -> player.getAge() < 35)
                .count();
        System.out.println("\nNumber of non-strikers under 35: " + count);

        System.out.println("\nAge of youngest midfielder or striker (SOLUTION 1):");
        players.stream()
                .filter(player -> player.getMainPosition().equals(Position.MIDFIELDER)
                                    || player.getMainPosition().equals(Position.STRIKER))
                .sorted(Player::compareTo)
                .map(Player::getAge)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\nAge of youngest midfielder or striker (SOLUTION 2):");
        players.stream()
                .filter(player -> player.getMainPosition().equals(Position.MIDFIELDER)
                        || player.getMainPosition().equals(Position.STRIKER))
                .mapToInt(Player::getAge)
                .min()
                .ifPresent(System.out::println);

        System.out.println("\nAge of youngest midfielder and striker:");
        List<Player> aux = players.stream()
                .filter(player -> player.getMainPosition().equals(Position.MIDFIELDER)
                        || player.getMainPosition().equals(Position.STRIKER))
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Midfielder:");
        aux.stream()
                .filter(player -> player.getMainPosition().equals(Position.MIDFIELDER))
                .mapToInt(Player::getAge)
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println("Striker:");
        aux.stream()
                .filter(player -> player.getMainPosition().equals(Position.STRIKER))
                .mapToInt(Player::getAge)
                .findFirst()
                .ifPresent(System.out::println);
    }

}
