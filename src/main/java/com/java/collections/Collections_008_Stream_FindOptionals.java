package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Collections_008_Stream_FindOptionals {

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

        Optional<String> firstPlayerUnder30 = players.stream()
                .filter(player -> player.getAge() < 30)
                .map(Player::getName)
                .findFirst();
        System.out.println("First player under 30: " + firstPlayerUnder30.orElse("None"));

        Optional<String> firstPlayerUnder20 = players.stream()
                .filter(player -> player.getAge() < 20)
                .map(Player::getName)
                .findFirst();
        System.out.println("First player under 20: " + firstPlayerUnder20.orElse("None"));
    }
}
