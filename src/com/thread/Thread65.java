package com.thread;

public class Thread65 {
    private static boolean doneWorking = false;

    public static void main(String arg[]){
        Thread t1 = new Thread(() -> {
            try{
                findTheTopFibonacciNumber();
            } catch (Exception e){
                System.out.println("Message: " + e.getMessage());
            }

            //findTheTopFibonacciNumber();

            doneWorking = true;
        });
        t1.start();


        try{
            Thread.sleep(500);
            if(t1.isAlive()){
                System.out.println("Thread t1 is still alive");
            }
            if(doneWorking) System.out.println("t1 thread finished");
            else System.out.println("t1 thread not finished");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static void findTheTopFibonacciNumber(){
        throw new RuntimeException("Something terribly bad happened");
    }

    private static int fib(int num){
        if(num == 1 || num == 2) return 1;
        else return fib(num - 1) + fib(num - 2);
    }
}
