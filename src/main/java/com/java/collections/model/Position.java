package com.java.collections.model;

import java.util.Arrays;
import java.util.List;

public enum Position {
    SOCCER_FAN(new Integer[] {1,2}),
    COACH(new Integer[] {3,4}),
    GOALKEEPER(new Integer[] {5,6}),
    DEFENDER(new Integer[] {7,8}),
    MIDFIELDER(new Integer[] {9,10}),
    STRIKER(new Integer[] {11, 12});

    Position(Integer[] aux) {
        positions = Arrays.asList(aux);
    }

    public List<Integer> positions;
}
