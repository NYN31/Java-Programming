package com.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread156 {
    public static class Philosopher extends Thread{
        private String name;
        private final Lock leftFork;
        private final Lock rightFork;

        public Philosopher(String name, Lock leftFork, Lock rightFork){
            this.name = name;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        private void log(String message) {
            String time = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
            System.out.println(Thread.currentThread() + ": " + message + time);
        }

        private void think(){
            log("Thinking");
        }
        private void eat(){
            try{
                log("Eating");
                TimeUnit.NANOSECONDS.sleep(1);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                throw new AssertionError(e);
            }
        }
        @Override
        public void run(){
            while(true){
                keepThinkingAndEating();
            }
        }
        public void keepThinkingAndEating(){
            think();

            if(leftFork.tryLock()){
                try{
                    log("Grabbed left fork");
                    if(rightFork.tryLock()){
                        try{
                            log("Grabbed right fork");
                            eat();
                        } finally {
                            log("Put down right fork");
                            rightFork.unlock();
                        }
                    }
                } finally {
                    log("Put down left fork");
                    leftFork.unlock();
                }
            }
        }
    }


    public static void main(String[] args){
        Lock[] forks = new Lock[5];

        for(int i=0; i<forks.length; i++){
            forks[i] = new ReentrantLock();
        }

        Philosopher[] philosophers = new Philosopher[5];
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0; i<philosophers.length; i++){
            Lock leftFork = forks[i];
            Lock rightFork = forks[(i + 1) % forks.length];

            philosophers[i] = new Philosopher("Philosophers " + (i + 1), leftFork, rightFork);
            executorService.execute(philosophers[i]);
        }
        executorService.shutdown();
    }
}
