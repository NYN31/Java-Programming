package com.practice;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class practiceA{
    public void add(int a, int b){
        System.out.println("add 1: " + a + b);
    }

    public void add(double a, int b){
        System.out.println("add 2: "  + a + b);
    }
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

    }
}