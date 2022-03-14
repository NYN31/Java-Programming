package com.kss;

import java.util.concurrent.TimeUnit;

public class Utils {
    public static void sleepOneSecond(){
        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
