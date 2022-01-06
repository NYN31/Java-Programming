package com.thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;


public class BlockingQueue138 {
    public static class Buffer{
        private BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);

        public void addItem(Integer item){
            try {
                queue.put(item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new AssertionError(e);
            }
        }

        public Integer getItem(){
            try {
                return queue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new AssertionError(e);
            }
        }
    }

    public static void main(String[] args){
        Buffer buffer = new Buffer();
        Random random = new Random();
        Thread producer = new Thread(() -> {
            while(true){
                int anInt = random.nextInt();
                System.out.println("Produced: " + anInt);
                buffer.addItem(anInt);
                sleepOneSecond();
            }
        });

        Thread consumer = new Thread(() -> {
            while(true){
                Integer item = buffer.getItem();
                System.out.println("Consumed: " + item);
                sleepOneSecond();
            }
        });

        producer.start();
        consumer.start();
    }

    private static void sleepOneSecond(){
        try{
            TimeUnit.MILLISECONDS.sleep(1000);
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}
