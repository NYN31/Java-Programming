package com.advance.chapter2;

public class targetTyping {
    /***
     * target type is a type which is fixed at a context.
     * ArrayList<String> list1 = new ArrayList<>();
     * ArrayList<Person> list1 = new ArrayList<>();
     * ***/

    public interface Addition{
        int add(int a, int b);
    }
    public interface Comparator{
        boolean eql(String a, String b);
    }

    public static void main(String args[]){
        int a, b;
        String x, y;
        a = 10;
        b = 11;
        x = "Hello";
        y = "Hello";

        Addition addition = (a1, b1) -> a1 + b1; // variable capturing or scope
        Comparator comparator = (x1, y1) -> x1.equals(y1);

        System.out.println("Addition: " + addition.add(a, b));
        System.out.println("Equality check: " + comparator.eql(x, y));
    }
}
