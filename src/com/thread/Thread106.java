package com.thread;

public class Thread106 {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void running() {
        synchronized (lock1) {
            log("Acquired lock1");
            synchronized (lock2) {
                log("Acquire lock2");
                System.out.println("Running");
                log("About to release lock2");
            }
            log("About to release lock1");
        }
    }

    public void walking() {
        synchronized (lock2) {
            log("Acquired lock2");
            synchronized (lock1) {
                log("Acquire lock1");
                System.out.println("Walking");
                log("About to release lock1");
            }
            log("About to release lock2");
        }
    }

    private static void log(String message) {
        System.out.println(message);
    }
}
