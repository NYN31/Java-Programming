package com.kss.thread2;

public class Java3RaceCondition {
    public static class BankAccount {
        private volatile long balance; // no need to use volatile here if synchronization has been done

        public BankAccount(long initialAmount) {
            this.balance = initialAmount;
        }

        public void withdraw(long amount) {
            System.out.println("Withdrawing " + amount);
            long newBalance = balance - amount;
            System.out.println("After withdraw New balance is: " + newBalance);
            balance = newBalance;
        }

        public void deposit(long amount) {
            System.out.println("Deposit " + amount);
            long newBalance = balance + amount;
            System.out.println("After deposit New balance is: " + newBalance);
            balance = newBalance;
        }

        public long getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);
        Thread depositThread = new Thread(() -> {
            for(int i=0; i<15; i++) {
                bankAccount.deposit(100);
                sleep();
            }
        });
        Thread withdrawThread = new Thread(() -> {
            for(int i=0; i<15; i++) {
                bankAccount.withdraw(100);
                sleep();
            }
        });

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Current balance: " + bankAccount.getBalance());
    }

    private static void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
