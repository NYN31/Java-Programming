package com.advance.chapter2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionalInf {

    public static void main(String args[]){
        Function<Integer, Integer> cubeIt = a -> a * a * a;
        Function<Integer, Integer> inc = a -> a + 1;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Integer ans = numbers.stream()
                .reduce(0, (sum, ele) -> sum + ele);
        System.out.println(ans);
    }
}
