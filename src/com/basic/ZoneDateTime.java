package com.basic;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class ZoneDateTime {
    public static void main(String args[]){
        Instant lt
                = Instant
                .parse("2018-10-20T16:55:30.00Z");

        // create a ZonID
        ZoneId zone = ZoneId.of("Asia/Dhaka");

        // apply ofInstant method
        // of ZonedDateTime class
        ZonedDateTime zt = ZonedDateTime
                .ofInstant(lt, zone).plusYears(5);

        // print the result
        System.out.println("ZonedDateTime is "
                + zt + "|" + ZonedDateTime.now());

        Instant timestamp = Instant.now();
        LocalDateTime ldt = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
        System.out.printf("%s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(),
                ldt.getYear(), ldt.getHour(), ldt.getMinute());
        System.out.println("ZoneDateTime: " + ZonedDateTime.now());
        System.out.println("LocalDateTime: " + LocalDateTime.now());

        Instant a = Instant.now().plus(6, ChronoUnit.DAYS);
        Instant b = Instant.now().minus(4, ChronoUnit.DAYS);
        if(a.isAfter(b)) System.out.println("1st: " + a + " " + b);
        else System.out.println("2nd: " + a + " " + b);
    }
}
