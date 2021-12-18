package com.advance.exceptions;

public class test1 {
    public static void func2(int a, int b){
        System.out.println("Print func2 method");
        try{
            int c = a / b;
            System.out.println(a / b);
            System.out.println("func2");
        } catch (ArithmeticException e){
            System.out.println("Message -> " + e);
        }
        System.out.println("Entry!");
    }
    public static void func1(int a, int b){
        System.out.println("Print func1 method");
        func2(a, b);
        System.out.println("func1");
    }
    public static void main(String args[]){
        int a, b, c;
        a = 5;
        b = 0;
        System.out.println("Print main method");
        func1(a, b);
        System.out.println("main");
    }
}
