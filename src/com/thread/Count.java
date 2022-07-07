package com.thread;

public class Count {
    public static class myRunnable implements Runnable{
        private volatile int count = 0;

        @Override
        public void run() {
            for(int i=0; i<1000000; i++) {
                synchronized (this) {
                    this.count += 1;
                }
            }

            System.out.println(Thread.currentThread().getName() + " : " + this.count);
        }
    }

    public static void main(String[] arg) {
        Runnable runnable = new myRunnable();

        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
