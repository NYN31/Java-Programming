package com.thread;

public class Thread78 {
    public volatile static boolean s3 = false;
    private static int count = 0;

    public static void main(String args[]){
        Thread t1 = new Thread(() -> {
            while(!s3){
                count += 1;
            }
            System.out.println("Hello! The count value is: " + count);
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            s3 = true;
            System.out.println("Hi! Value of boolean flag is becomes true! " + count);
        });
        //t1.start();
        t2.start();
    }
}
