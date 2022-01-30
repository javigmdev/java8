package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.List;

public class Collections_006_Stream_Practice {
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

        System.out.println("Youngest midfielder:");
        players.stream()
                .filter(player -> player.getMainPosition().equals(Position.MIDFIELDER))
                .mapToInt(Player::getAge)
                .min()
                .ifPresent(System.out::println);

        System.out.println("Second youngest midfielder:");
        players.stream()
                .filter(player -> player.getMainPosition().equals(Position.MIDFIELDER))
                .sorted()
                .skip(1)
                .mapToInt(Player::getAge)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("Name of midfielders alphabetically without the youngest and without the oldest:");
        players.stream()
                .filter(player -> player.getMainPosition().equals(Position.MIDFIELDER))
                .sorted()
                .skip(1)
                .sorted((player1, player2) -> player1.compareTo(player2) * -1)
                .skip(1)
                .sorted()
                .map(Player::getName)
                .forEach(System.out::println);
    }
}
