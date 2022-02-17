package com.java.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DateTime_000_LocalDate {

    public static void main(String[] args) {
        System.out.println("LocalDate: represents a date in ISO format (yyyy-MM-dd) without time");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        System.out.println("\nRepresenting a specific day:");
        System.out.println(LocalDate.of(2015, 02, 20));
        System.out.println(LocalDate.parse("2015-02-20"));

        System.out.println("\nUtility methods:");
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println("Tomorrow: " + tomorrow);

        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("Previous month: "+ previousMonthSameDay);

        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
        System.out.println("Day of week: " + sunday);

        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
        System.out.println("Day of month: " + twelve);

        boolean leapYear = LocalDate.now().isLeapYear();
        System.out.println("Is leap year? " + leapYear);

        boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
        System.out.println("Is before? " + notBefore);

        boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));
        System.out.println("Is after? " + isAfter);

        LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
        System.out.println("Beginning of day: " + beginningOfDay);
        LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("First day of month: " + firstDayOfMonth);
    }
}
