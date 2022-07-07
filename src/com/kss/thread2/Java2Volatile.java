package com.kss.thread2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Java2Volatile {
    public static class Watch implements Runnable {
        private static final DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("HH:mm:s a");
        private boolean running = true; // use volatile

        @Override
        public void run() {
            while(running) {
                System.out.println(Thread.currentThread().getName() + " In while method");
                printCurrentTime();
                sleepOneSecond();
            }
        }

        public void shutdown() {
            System.out.println("In shut down method!");
            this.running = false;
        }

        private static void sleepOneSecond(){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        private static void printCurrentTime(){
            String formattedCurrentTime = LocalDateTime.now().format(formatter);
            System.out.println(formattedCurrentTime);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Watch watch = new Watch();
        Thread t1 = new Thread(watch);
        Thread t2 = new Thread(watch);
        t1.start();
        t2.start();


        Thread.sleep(5000);
        watch.shutdown();
    }
}
