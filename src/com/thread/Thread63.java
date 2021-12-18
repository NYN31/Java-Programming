package com.thread;

import java.util.concurrent.TimeUnit;

public class Thread63 {
    private static boolean doneWorking = false;

    public static void main(String arg[]){
        Thread t1 = new Thread(() -> {
            findTheTopFibonacciNumber();
            doneWorking = true;
            System.out.println("Thread name: " + Thread.currentThread().getName());
        });
        t1.setName("Tread t1");
        t1.start();

        try{
            Thread.sleep(5);
            if(doneWorking) System.out.println("t1 thread finished");
            else System.out.println("t1 thread not finished");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

    private static void findTheTopFibonacciNumber(){
        for(int value = 1; value <= 20; value++){
            System.out.println(value + " -> " + fib(value));
        }
    }

    private static int fib(int num){
        if(num == 1 || num == 2) return 1;
        else return fib(num - 1) + fib(num - 2);
    }
}
