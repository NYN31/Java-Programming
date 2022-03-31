package com.kss.thread1;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.kss.Utils.sleepOneSecond;

// create thread extending Thread class
public class Ex2_ExtendedThreadMain {
    public static void main(String[] args){
        Ex2_ExtendedThread extendedThread = new Ex2_ExtendedThread();

        extendedThread.setName("Extended Thread");
        extendedThread.start();

        for(int i=0; i<5; i++){
            System.out.println("[" + i + "] Inside " + Thread.currentThread().getName() + " " + LocalDateTime.now());
            sleepOneSecond();
        }
    }
}
