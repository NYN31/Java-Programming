package com.kss.thread1;

import static com.kss.Utils.sleepOneSecond;

// Create thread using Runnable interface which is a functional interface
public class Ex3_RunnableThreadMain {
    public static void main(String[] args){
        Ex3_RunnableThread runnable = new Ex3_RunnableThread();
        Thread myRunnableThread = new Thread(runnable);
        myRunnableThread.setName("Runnable Thread");
        myRunnableThread.start();

        for(int i=0; i<5; i++){
            System.out.println("[" + i + "] Inside " + Thread.currentThread().getName());
            sleepOneSecond();
        }
    }
}
