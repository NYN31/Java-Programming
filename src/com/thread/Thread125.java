package com.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;

public class Thread125 {
    private final static int SIZE = 10;
    private Queue<Integer> queue = new LinkedList<>();
    private final Object lock = new Object();

    private void log(String message) {
        String time = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
        System.out.println(Thread.currentThread() + ": " + message + time);
    }

    public void addItem(int item){
        synchronized (lock){
            while(queue.size() == SIZE){
                log("Size is full, let's wait");
                try{
                    wait();
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
            }
            log("Thread Resume!");
            log("Adding item: " + item);
            queue.add(item);
            log("Item added, let's notify");
            lock.notifyAll();
        }
    }

    public Integer getItem(int item){
        synchronized (lock){
            while(queue.isEmpty()){
                log("Queue is empty, let's wait");
                try{
                    wait();
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
            }
            log("Thread Resume!");
            log("Let's consume value");
            Integer value = queue.poll();

            log("Consumed value: " + value);
            lock.notifyAll();
            return value;
        }
    }
}
