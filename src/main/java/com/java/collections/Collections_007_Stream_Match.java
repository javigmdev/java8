package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.List;

public class Collections_007_Stream_Match {
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

        System.out.println("allMatch (terminal operation): returns whether all elements of this stream match the provided predicate");
        boolean isAllAgeWorking = players.stream()
                .allMatch(player -> player.getAge() < 67);
        System.out.println("Are all workers of working age? " + isAllAgeWorking);

        System.out.println("anyMatch (terminal operation): returns whether any elements of this stream match the provided predicate");
        boolean isAnyoneAgeWorking = players.stream()
                .anyMatch(player -> player.getAge() < 67);
        System.out.println("Is anyone of working age? " + isAnyoneAgeWorking);

        System.out.println("noneMatch (terminal operation): returns whether no elements of this stream match the provided predicate");
        boolean isNone = players.stream()
                .noneMatch(player -> player.getAge() == 66);
        System.out.println("Is there no one with 66 years old? " + isNone);
    }
}
