package com.thread;

import java.util.concurrent.TimeUnit;

public class Thread74 {
    private Integer number;

    public Integer getNumber() {
        return this.number;
    }
    public void setNumber(Integer number){
        this.number = number;
    }

    public static void main(String args[]){
        Thread74 thread74 = new Thread74();
        setARandomeNumber(thread74);

        Thread thread1 = new Thread(() -> {
            setARandomeNumber(thread74);
        });

        Thread thread2 = new Thread(() -> {
            setARandomeNumber(thread74);
        });

        thread1.start(); thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Value: " + thread74.getNumber());
    }

    private static void setARandomeNumber(Thread74 thread74){
        thread74.setNumber((int)(Math.random() * 100));

        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Value: " + thread74.getNumber());
    }
}
