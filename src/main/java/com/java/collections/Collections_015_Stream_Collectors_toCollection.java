package com.java.collections;

import com.java.collections.model.Player;

import java.util.*;
import java.util.stream.Collectors;

public class Collections_015_Stream_Collectors_toCollection {

    public static void main(String[] args) {
        List<Player> players = Arrays.asList(
                new Player("William",48),
                new Player("Muller",60),
                new Player("Kane",25),
                new Player("Gerard",48),
                new Player("Rooney",69),
                new Player("Cooper",29),
                new Player("William",25));

        List<String> list = players.stream()
            .map(Player::getName)
            .collect(Collectors.toList());
        System.out.println("toList: " + list);

        Set<String> set = players.stream()
                .map(Player::getName)
                .collect(Collectors.toSet());
        System.out.println("toSet: " + set);

        ArrayList<Player> arrayList = players.stream()
                .collect(Collectors.toCollection(() -> new ArrayList<>()));

        LinkedList<Player> linkedList = players.stream()
                .collect(Collectors.toCollection(LinkedList::new));

        LinkedHashSet<Player> linkedHashSet = players.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println("Collectors toCollection: is used to create a Collection");
        System.out.println("arrayList: " + arrayList);
        System.out.println("linkedList: " + linkedList);
        System.out.println("linkedHashSet: " + linkedHashSet);
    }
}
