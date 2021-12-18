package com.advance.stream;

import java.util.stream.IntStream;

public class Stream197 {
    /***
     * prime number
     * ***/

    public static void main(String args[]) {
        int number = 50;

        IntStream.range(0, 50)
                .filter(value -> isPrime(value))
                .limit(10)
                .forEach(val -> System.out.print(val + " "));
    }
    private static boolean isPrime(int number){
        if(number < 2) return false;

        return IntStream.rangeClosed(2, number / 2)
                .noneMatch(i -> number % i == 0);
    }
}
