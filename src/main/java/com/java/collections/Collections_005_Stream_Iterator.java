package com.java.collections;

import com.java.collections.model.Player;
import com.java.collections.model.Position;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Collections_005_Stream_Iterator {

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

        System.out.println("forEach terminal operation (void):");
        players.stream()
                .filter(player -> player.getName().startsWith("M"))
                .forEach(player -> System.out.println(player.getName()));

        System.out.println("iterator terminal operation (void):");
        Iterator<Player> iterator = players.stream().iterator();
        while(iterator.hasNext()){
            Player player = iterator.next();
            if(player.getName().startsWith("M")){
                System.out.println(player.getName());
            }
        }

        System.out.println("toArray:");
        Player[] players2 = players.toArray(new Player[players.size()]);
        System.out.println(Arrays.toString(players2));

        System.out.println("toArray with stream:");
        String[] names = players.stream()
                .map(Player::getName)
                .toArray(String[]::new);
        List<String> listName = Arrays.asList(names);
        System.out.println(Arrays.toString(names));
    }
}
