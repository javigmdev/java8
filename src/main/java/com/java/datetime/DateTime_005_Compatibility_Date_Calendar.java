package com.java.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateTime_005_Compatibility_Date_Calendar {

    public static void main(String[] args) {
        System.out.println("toInstant: convert existing Date and Calendar instance to new Date and Time API");
        Date date = new Date();
        System.out.println("Date to LocalDateTime: " + LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
        Calendar calendar = Calendar.getInstance();
        System.out.println("Calendar to LocalDateTime: " + LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault()));
    }
}
