package com.kss.thread1;

public class EX4_AnonymousClassMain {
    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork("Comes From anonymous inner class.");
            }
        });
        t1.start();




        Thread t2 = new Thread(() -> doWork("Comes form lambda Expression."));
        t2.start();
    }

    private static void doWork(String message){
        System.out.println(message);
    }
}
