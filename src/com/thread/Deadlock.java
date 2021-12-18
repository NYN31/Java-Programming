package com.thread;

public class Deadlock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void running(){
        synchronized (lock1){
            log("Acquire lock1");
            synchronized (lock2){
                log("Acquire lock2");
            }
        }
    }
    public void walking(){
        synchronized (lock2){
            log("Acquire lock2");
            synchronized (lock1){
                log("Acquire lock1");
            }
        }
    }

    private void log(String msg){
        System.out.println(msg);
    }
}
