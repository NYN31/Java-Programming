package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Thread162 {
    public static class Developer implements Runnable{
        private CountDownLatch latch;
        private String name;

        public Developer(String name, CountDownLatch latch){
            this.latch = latch;
            this.name = name;
        }

        @Override
        public void run(){
            System.out.println(String.format("Task assigned to developer: %s", name));
            try{
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                throw new AssertionError(e);
            }

            System.out.println(String.format("Task finished by developer: %s", name));
            this.latch.countDown();
        }
    }

    public static class Tester implements Runnable{
        private CountDownLatch latch;
        private String name;

        public Tester(String name, CountDownLatch latch){
            this.latch = latch;
            this.name = name;
        }

        @Override
        public void run(){
            try{
                System.out.println(String.format("Tester %s waiting for developers to finish their work!%n", name));
                latch.await();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                throw new AssertionError(e);
            }

            System.out.println(String.format("Testing done by tester: %s!%n", name));
            this.latch.countDown();
        }
    }

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(5);

        Developer developer1 = new Developer("Developer #1", latch);
        Developer developer2 = new Developer("Developer #2", latch);
        Developer developer3 = new Developer("Developer #3", latch);
        Developer developer4 = new Developer("Developer #4", latch);
        Developer developer5 = new Developer("Developer #5", latch);
        Tester tester1 = new Tester("Tester #1", latch);
        Tester tester2 = new Tester("Tester #2", latch);


        executorService.execute(developer1);
        executorService.execute(developer2);
        executorService.execute(developer3);
        executorService.execute(developer4);
        executorService.execute(developer5);

        executorService.execute(tester1);
        executorService.execute(tester2);

        executorService.shutdown();
    }
}
