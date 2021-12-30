package com.basic.oop;

public class test {
    public static void main(String args[]){
        Hello hlo = new HelloImpl();
        hlo.hello();
        HelloImpl.helloStatic();

        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
