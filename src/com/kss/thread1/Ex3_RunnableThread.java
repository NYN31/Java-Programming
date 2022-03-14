package com.kss.thread1;

import static com.kss.Utils.sleepOneSecond;

public class Ex3_RunnableThread implements Runnable{
    @Override
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("[" + i + "] Inside " + Thread.currentThread().getName());
            sleepOneSecond();
        }
    }
}
