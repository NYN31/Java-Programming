package com.thread;

import java.util.concurrent.TimeUnit;

public class Thread72 {
    public static void main(String args[]){

        Thread thread = new Thread(() -> {
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                System.err.println("Thread Interrupted deu  to " + e.getMessage());
            }

            throw new RuntimeException("Goodbye cruel world!");
        });

        thread.setUncaughtExceptionHandler(new Thread71());
        thread.start();
    }
}
