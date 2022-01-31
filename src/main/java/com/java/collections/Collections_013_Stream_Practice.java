package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.List;

public class Collections_013_Stream_Practice {

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

        players.stream()
                .filter((player -> Position.MIDFIELDER.equals(player.getMainPosition())))
                .mapToInt(Player::getAge)
                .average()
                .ifPresent(averageMidfielder -> System.out.println("Average midfielder: " + averageMidfielder));

        players.stream()
                .filter((player -> Position.MIDFIELDER.equals(player.getMainPosition())))
                .sorted()
                .skip(1)
                .sorted((player1, player2) -> player1.compareTo(player2) * -1)
                .skip(1)
                .mapToInt(Player::getAge)
                .average()
                .ifPresent(average -> System.out.println("Average midfielder without the youngest and without the oldest: " + average));

        System.out.println("Sum ages by position: ");
        Integer sumAgeGoalkeeper = players.stream()
                .filter((player) -> Position.GOALKEEPER.equals(player.getMainPosition()))
                .map(Player::getAge)
                .reduce(0, Integer::sum);

        Integer sumAgeDefender = players.stream()
                .filter((player) -> Position.DEFENDER.equals(player.getMainPosition()))
                .map(Player::getAge)
                .reduce(0, Integer::sum);

        int sumAgeMidfielder = players.stream()
                .filter((player) -> Position.MIDFIELDER.equals(player.getMainPosition()))
                .mapToInt(Player::getAge)
                .sum();

        int sumAgeStriker = players.stream()
                .filter((player) -> Position.STRIKER.equals(player.getMainPosition()))
                .mapToInt(Player::getAge)
                .sum();

        System.out.println("Goalkeepers: " + sumAgeGoalkeeper);
        System.out.println("Defenders: " + sumAgeDefender);
        System.out.println("Midfielders: " + sumAgeMidfielder);
        System.out.println("Strikers: " + sumAgeStriker);
    }
}
