package com.java.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTime_004_Period_Duration {
    public static void main(String[] args) {
        System.out.println("Period: is widely used to modify values of given a date or to obtain the difference between two dates");
        LocalDate initialDate = LocalDate.parse("2007-05-10");
        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        System.out.println("Add period of days: " + finalDate);
        int periodDays = Period.between(initialDate, finalDate).getDays();
        System.out.println("Period between two dates: " + periodDays);
        long periodDays1 = ChronoUnit.DAYS.between(initialDate, finalDate);
        System.out.println("Period between two dates (ChronoUnit): " + periodDays1);

        System.out.println("\nDuration: is used to deal with Time");
        LocalTime initialTime = LocalTime.of(6, 30, 0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
        System.out.println("Add time: " + finalTime);

        long periodTime = Duration.between(initialTime, finalTime).getSeconds();
        System.out.println("Period between two times: " + periodTime);
        periodTime = ChronoUnit.SECONDS.between(initialTime, finalTime);
        System.out.println("Period between two times (ChronoUnit): " + periodTime);
    }
}
