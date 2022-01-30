package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Collections_009_Stream_Map_toNumber {

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

        IntSummaryStatistics stats = players.stream()
                .mapToInt(Player::getAge)
                .summaryStatistics();

        System.out.println("Summary statics: " + stats);

        IntStream ageInt = players.stream()
                .filter(player -> player.getMainPosition().equals(Position.GOALKEEPER))
                .mapToInt(Player::getAge);
        System.out.println("Int sum: " + ageInt.sum());

        DoubleStream ageDouble = players.stream()
                .mapToDouble(Player::getAge);
        System.out.println("Double average: " + ageDouble.average());
    }
}
