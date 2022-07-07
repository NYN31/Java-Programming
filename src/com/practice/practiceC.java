package com.practice;

public class practiceC {
    private static boolean flag = true;

    public static class TestThread implements Runnable {
        private Thread thread;
        private String threadName;

        TestThread(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            while(flag) {
                System.out.println(threadName);
            }
        }

        public void start() {
            System.out.println("Hello there");
            if(thread == null) {
                thread = new Thread(this, threadName);
                thread.start();
            }
        }
    }

    public static void main(String[] args) {
        TestThread t1 = new TestThread("A");
        TestThread t2 = new TestThread("B");
        t1.start();
        t2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        flag = false;
    }
}
