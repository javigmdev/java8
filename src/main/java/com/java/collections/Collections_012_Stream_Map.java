package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collections_012_Stream_Map {

    public static void main(String[] args) {

        List<Player> players1 = Arrays.asList(
                new Player("Rooney", 48, Position.STRIKER,
                           Arrays.asList(Position.STRIKER, Position.MIDFIELDER)),
                new Player("Gerard", 30, Position.MIDFIELDER,
                        Arrays.asList(Position.MIDFIELDER, Position.GOALKEEPER)),
                new Player("Frank", 25, Position.DEFENDER,
                        Arrays.asList(Position.DEFENDER, Position.MIDFIELDER))
        );

        List<Player> players2 = Arrays.asList(
                new Player("Kane", 48, Position.STRIKER,
                        Arrays.asList(Position.STRIKER, Position.MIDFIELDER)),
                new Player("David", 30, Position.SOCCER_FAN,
                        Arrays.asList(Position.SOCCER_FAN, Position.GOALKEEPER)),
                new Player("Cole", 25, Position.COACH,
                        Arrays.asList(Position.COACH, Position.MIDFIELDER))
        );

        HashMap<Integer, List<Player>> mapPlayer = new HashMap<>();
        mapPlayer.put(1, players1);
        mapPlayer.put(2, players2);

        System.out.println("forEach with map:");
        mapPlayer.forEach((key, player) -> {
            player.forEach(System.out::println);
        });

        Map<String, Integer> mapString = new HashMap<>();
        mapString.put("1", 1);
        mapString.put("2", 2);

        System.out.println("merge with map:");
        mapString.merge("3", 3, (key,value) -> {
            throw new RuntimeException("Key " + key + " already exists");
        });
        System.out.println(mapString);

        mapString.merge("3", 3, (key, value) -> value * 2);
        System.out.println(mapString);
    }
}
