package com.advance.stream;

import java.util.UUID;
import java.util.stream.Stream;

public class Stream177 {
    public static void main(String args[]){
        /***
         * Stream.iterate(T first, BinaryOperator<T> f)
         * .limit() -> short circuiting operation
         * printing a sequence 1, 2, 4, 8, 16, 32 ...........
         ***/
        Stream<Integer> sequence = Stream.iterate(1, val -> val * 2).limit(10);
        sequence.forEach(val -> System.out.print(val + " "));
        System.out.println();


        /***
         * printing value from 1 to 20 using stream and short circuit
         * ***/
        Stream.iterate(1, val -> ++val)
                .limit(20)
                .forEach(val -> System.out.print(val + " "));
        System.out.println();


        /***
         * Stream.iterate(T first, Predicate<T> test, BinaryOperator<T> f)
         * Doesn't need short circuit operation
         * printing from 1 to 10
         * ***/
        Stream.iterate(1, val -> val <= 10, val -> val + 1)
                .forEach(val -> System.out.print(val + " "));
        System.out.println();


        /***
         * Stream.generate(Supplier<T> f)
         * printing 10 random value using UUID
         * ***/
        Stream.generate(UUID::randomUUID)
                .limit(10)
                .forEach(val -> System.out.print(val + " | "));
        System.out.println();


    }
}
