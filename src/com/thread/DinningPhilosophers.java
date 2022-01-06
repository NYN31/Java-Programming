package com.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class DinningPhilosophers {
    public static class Fork{
        // just an object
    }

    public static class Philosopher extends Thread{
        private String name;
        private final Fork leftFork;
        private final Fork rightFork;

        public Philosopher(String name, Fork leftFork, Fork rightFork){
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
            synchronized (leftFork){
                log("Grabbed left fork");
                synchronized (rightFork){
                    log("Grabbed right fork");
                    eat();
                    log("Put down right fork");
                }
                log("Put down left fork");
            }
        }
    }

    public static void main(String[] args){
        Fork[] forks = new Fork[5];

        for(int i=0; i<forks.length; i++){
            forks[i] = new Fork();
        }

        Philosopher[] philosophers = new Philosopher[5];
        for(int i=0; i<philosophers.length; i++){
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % forks.length];

            if(i == philosophers.length - 1) {
                philosophers[i] = new Philosopher("Philosopher " + (i + 1), rightFork, leftFork);
                philosophers[i].start();
            } else {
                philosophers[i] = new Philosopher("Philosopher " + (i + 1), leftFork, rightFork);
                philosophers[i].start();
            }
        }
    }
}
