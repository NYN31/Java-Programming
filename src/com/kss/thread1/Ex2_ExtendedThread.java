package com.kss.thread1;

import static com.kss.Utils.sleepOneSecond;

public class Ex2_ExtendedThread extends Thread{
    @Override
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("[" + i + "] Inside " + Thread.currentThread().getName());
            sleepOneSecond();
        }
    }
}
