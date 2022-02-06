package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collections_017_Stream_Collectors_Calculating_Utilities {

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

        System.out.println("Collectors maxBy: return the max element of the collection");
        Optional<Player> maxAgePlayer = players.stream()
                .collect(Collectors.maxBy(Player::compareTo));
        maxAgePlayer.ifPresent(player -> System.out.println("Max age player: " + maxAgePlayer.get().getName()));

        System.out.println("\nCollectors summarizingInt: return the summary statistics obtained from applying the passed ToIntFunction");
        IntSummaryStatistics summaryAgePlayer = players.stream()
                .collect(Collectors.summarizingInt(Player::getAge));
        System.out.println("Summary age players: " + summaryAgePlayer);
    }
}
