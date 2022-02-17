package com.java.datetime;

import java.time.LocalDateTime;
import java.time.Month;

public class DateTime_002_LocalDateTime {

    public static void main(String[] args) {
        System.out.println("LocalDateTime: represent a combination of date and time");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Now: " + now);

        System.out.println("\nRepresenting a hour time: ");
        System.out.println(LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30));
        System.out.println(LocalDateTime.parse("2015-02-20T06:30:00"));

        System.out.println("\nUtility methods:");
        System.out.println("Add day: " + now.plusDays(1));
        System.out.println("Minus hours: " + now.minusHours(2));
        System.out.println("Get month: " + now.getMonth());
    }
}
