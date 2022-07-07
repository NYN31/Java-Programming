package com.thread.signleton.pattern;

public class SingletonClass {
    private static class Singleton {
        // no change, object reference will same for whole time
        private static Singleton single_instance = null;

        // Constructor
        // Here we will be creating private constructor
        // restricted to this class itself
        private Singleton()
        {
            // initialize something
        }

        // Static method to create instance of Singleton class
        public static Singleton getInstance()
        {
            if (single_instance == null)
                single_instance = new Singleton();

            return single_instance;
        }
    }

    public static void main(String args[])
    {
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        Singleton z = Singleton.getInstance();

        System.out.println("Hashcode of x is " + x.hashCode());
        System.out.println("Hashcode of y is " + y.hashCode());
        System.out.println("Hashcode of z is " + z.hashCode());

        // Condition check
        if (x == y && y == z) {
            System.out.println(
                    "Three objects point to the same memory location on the heap i.e, to the same object");
        }
        else {
            System.out.println(
                    "Three objects DO NOT point to the same memory location on the heap");
        }
    }
}
