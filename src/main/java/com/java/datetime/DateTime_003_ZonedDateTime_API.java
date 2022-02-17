package com.java.datetime;

import java.time.*;
import java.util.Set;

public class DateTime_003_ZonedDateTime_API {

    public static void main(String[] args) {
        System.out.println("ZonedDateTime: provides a time-zone-specific date and time");
        ZoneId zoneIdParis = ZoneId.of("Europe/Paris");
        System.out.println("Paris: " + zoneIdParis);

        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("All zones: "+ allZoneIds);

        System.out.println("The LocalDateTime can be converted to a specific zone: " + ZonedDateTime.of(LocalDateTime.now(), zoneIdParis));
        System.out.println("Parse: " + ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]"));

        System.out.println("\nOffSetDateTime: immutable representation of a date-time with an offset");
        System.out.println("The OffSetDateTime instance can be created using ZoneOffset");
        System.out.println("Add two hours to the time by creating a ZoneOffset and setting for the localDateTime instance:");
        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
        ZoneOffset offset = ZoneOffset.of("+02:00");
        OffsetDateTime offSetByTwo = OffsetDateTime.of(localDateTime, offset);
        System.out.println(offSetByTwo);
    }
}
