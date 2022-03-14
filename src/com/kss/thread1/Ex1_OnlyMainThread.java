package com.kss.thread1;

import static com.kss.Utils.sleepOneSecond;

public class Ex1_OnlyMainThread {
    public static void main(String[] args){
        for(int i=0; i<5; i++){
            System.out.println("[" + i + "] First loop & Inside " + Thread.currentThread().getName());
            sleepOneSecond();
        }

        for(int i=0; i<5; i++){
            System.out.println("[" + i + "] Second loop & Inside " + Thread.currentThread().getName());
            sleepOneSecond();
        }
    }
}
