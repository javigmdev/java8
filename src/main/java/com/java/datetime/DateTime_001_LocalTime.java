package com.java.datetime;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DateTime_001_LocalTime {

    public static void main(String[] args) {
        System.out.println("LocalTime: represents time without a date");
        LocalTime now = LocalTime.now();
        System.out.println("Now: " + now);

        System.out.println("\nRepresenting a hour time: ");
        LocalTime sixThirty = LocalTime.parse("06:30");
        System.out.println(sixThirty);
        sixThirty = LocalTime.of(6, 30);
        System.out.println(sixThirty);

        System.out.println("\nUtility methods:");
        LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
        System.out.println("Add hour: " + sevenThirty);
        int six = LocalTime.parse("06:30").getHour();
        System.out.println("Get hour: " + six);
        boolean isBefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
        System.out.println("is before? " + isBefore);
        LocalTime maxTime = LocalTime.MAX;
        System.out.println("Max time: " + maxTime);
    }
}
