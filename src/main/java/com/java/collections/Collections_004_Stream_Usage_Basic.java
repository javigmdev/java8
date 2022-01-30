package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collections_004_Stream_Usage_Basic {
    public static void main(String[] args) {
        List<Player> repeatPlayers = Arrays.asList(
                new Player("William",48, Position.GOALKEEPER),
                new Player("Kane",60, Position.GOALKEEPER),
                new Player("Nuno",25, Position.GOALKEEPER),
                new Player("Gerard",48, Position.DEFENDER),
                new Player("Cooper",69, Position.DEFENDER),
                new Player("Rooney",29, Position.DEFENDER),
                new Player("Rooney",29, Position.DEFENDER),
                new Player("Rooney",29, Position.DEFENDER),
                new Player("Rooney",29, Position.DEFENDER),
                new Player("Rooney",29, Position.DEFENDER),
                new Player("Rooney",29, Position.DEFENDER),
                new Player("Rooney",29, Position.DEFENDER),
                new Player("Rooney",29, Position.DEFENDER),
                new Player("Cole",25, Position.MIDFIELDER),
                new Player("Bloomer",50, Position.MIDFIELDER),
                new Player("Stiles",35, Position.MIDFIELDER),
                new Player("Butt",20, Position.MIDFIELDER),
                new Player("Byrne",31, Position.STRIKER),
                new Player("Barnes",50, Position.STRIKER),
                new Player("Moore",42, Position.STRIKER),
                new Player("Moore", 27, Position.SOCCER_FAN),
                new Player("Charlton", 88, Position.SOCCER_FAN),
                new Player("Rowe", 96, Position.SOCCER_FAN));

        System.out.println("Count:" + repeatPlayers.stream().count());

        System.out.println("Count distinct: " + repeatPlayers.stream().distinct().count());

        System.out.println("Count distinct skip 3: " + repeatPlayers.stream().distinct().skip(3).count());

        System.out.println("Count distinct limit 3: " + repeatPlayers.stream().distinct().limit(3).count());

        repeatPlayers.stream()
                .distinct()
                .min(Player::compareTo)
                .ifPresent(player -> System.out.println("Youngest player: " + player.getName()));

        repeatPlayers.stream()
                .distinct()
                .max(Player::compareTo)
                .ifPresent(player -> System.out.println("Oldest player: " + player.getName()));

        System.out.println("Peek:");
        repeatPlayers.stream()
                .map(Player::getName)
                .filter(p -> p.contains("i"))
                .peek(v -> System.out.println("contain i => "+v))
                .filter(p -> p.contains("W"))
                .peek(v -> System.out.println("contain W=> "+v))
                .collect(Collectors.toList());
    }
}
