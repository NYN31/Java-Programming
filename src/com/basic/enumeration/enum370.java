package com.basic.enumeration;

public class enum370 {
    enum People{
        John(5), Mark(6), Tony(4), Rok(3);
        private int age; // each constant has a copy of it
        People(int age){ this.age = age; }
        int getAge() { return age; }
    }

    public static void main(String[] args){
        People p = People.valueOf("John");
        Integer x = People.John.getAge();
        System.out.println(p);
        System.out.println(x);
    }
}
