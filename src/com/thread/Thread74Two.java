package com.thread;

import java.util.concurrent.TimeUnit;

public class Thread74Two {
    private ThreadLocal<Integer> number = new ThreadLocal<>();

    public Integer getNumber() {
        return number.get();
    }
    public void setNumber(Integer number){
        this.number.set(number);
    }

    public static void main(String args[]){
        Thread74Two thread74Two = new Thread74Two();
        setARandomeNumber(thread74Two);

        Thread thread1 = new Thread(() -> {
            setARandomeNumber(thread74Two);
        });

        Thread thread2 = new Thread(() -> {
            setARandomeNumber(thread74Two);
        });

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Value: " + thread74Two.getNumber());
    }

    private static void setARandomeNumber(Thread74Two thread74Two){
        thread74Two.setNumber((int)(Math.random() * 100));

        try{
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Value: " + thread74Two.getNumber());
    }
}
