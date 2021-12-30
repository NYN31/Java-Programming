package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Thread146 {
    public static void main(String args[]){
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        IntStream.range(0, 100).forEach(i -> {
            Runnable task = new Runnable(){
                @Override
                public void run(){
                    String threadName = Thread.currentThread().getName();
                    System.out.printf("Thread: %s is executing task: %d\n", threadName, i);
                }
            };
            executorService.execute(task);
        });

        executorService.shutdown();
    }
}
