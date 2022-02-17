package com.java.datetime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateTime_006_Formatting {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
        String localDateString = localDateTime.format(DateTimeFormatter.ISO_DATE);
        System.out.println("Passes an ISO date format: " + localDateString);

        System.out.println("\nDateTimeFormatter: provides various standard formatting options");
        System.out.println("Format yyyy/MM/dd: " + localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

        System.out.println("Format style:");
        System.out.println("Short: " + localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.UK)));
        System.out.println("Medium: " + localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.UK)));
    }
}
