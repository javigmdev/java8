package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collections_014_Stream_Collectors_Utilities {

    private static final String DELIMITER = ",";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

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

        String names = players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(DELIMITER));
        System.out.println("Collectors joining: " + names);

        String names2 = players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
        System.out.println("Collectors joining [,]: " + names2);

        Long count = players.stream()
                .filter(player -> player.getAge() > 80)
                .collect(Collectors.counting());
        System.out.println("Collectors count: " + count);

        List<String> upperNames = players.stream()
                .filter(player -> player.getAge() > 80)
                .collect(Collectors.mapping(player -> player.getName(), Collectors.toList()));
        System.out.println("Collectors mapping: " + upperNames);

        String upperNameGoalkeepers = players.stream()
                .filter(player -> Position.GOALKEEPER.equals(player.getMainPosition()))
                .collect(Collectors.mapping(
                        player -> player.getName().toUpperCase(),
                        Collectors.joining(DELIMITER)
                ));
        System.out.println("Upper name goalkeeper: " + upperNameGoalkeepers);

        players.stream()
                .filter(player -> Position.GOALKEEPER.equals(player.getMainPosition()))
                .collect(Collectors.mapping(
                        Player::getAge,
                        Collectors.maxBy(Integer::compareTo)
                ))
                .ifPresent(age -> System.out.println("Eldest goalkeeper: " + age));
    }
}
