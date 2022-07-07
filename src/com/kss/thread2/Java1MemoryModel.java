package com.kss.thread2;

public class Java1MemoryModel {

    public static class MyObject {

    }
    public static class myRunnable implements Runnable {

        private static String STATIC_VARIABLE = "Static variable";
        private int count = 0; // member variable

        @Override
        public void run() {

            MyObject myObject = new MyObject();
            System.out.println("MyObject: " + myObject); // [create different object for different thread

            for (int i = 0; i < 1000000; i++) {
                this.count += 1;
            }

            System.out.println(Thread.currentThread().getName() + " : " + count);
        }
    }

    public static void main(String[] arg) {

        //int id = 1001; [Thread stack]
        //String name = "Noyon"; [Heap, thread stack]

        Runnable runnable = new myRunnable();

        Thread thread1 = new Thread(runnable, "Thread-1");
        Thread thread2 = new Thread(runnable, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
