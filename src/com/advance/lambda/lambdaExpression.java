package com.advance.lambda;

public class lambdaExpression {

    @FunctionalInterface
    public interface Adder{
        int add(int a, int b);
    }

    public static class AdderImpl implements Adder{
        @Override
        public int add(int a, int b){
            return a + b;
        }
    }
    public static void main(String args[]){
        Adder adder1 = (a, b) -> a + b;
        var sum = adder1.add(4,5);
        System.out.println("SUM1: " + sum);

        Adder adder2 = new Adder(){
            @Override
            public int add(int a, int b){
                return a + b;
            }
        };
        sum = adder2.add(4, 6);
        System.out.println("SUM2: " + sum);

        Adder adder3 = new AdderImpl();
        sum = adder3.add(4,7);
        System.out.println("SUM3: " + sum);
    }
}

/***
 * Characters: anonymous, has parameter, return type and exception list like function
 * can be sent like method  parameter and also can be  store in a variable, Simple,
 * there has no tension about boilerplate code that's why hesitation might be less.
 *
 * Syntax: (PARAMETERS) -> { BODY }
 * ***/
