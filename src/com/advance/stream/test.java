package com.advance.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class test {
    public static class Person{
        private int age;
        private String name;
        private String regNumber;

        public Person(int age, String name, String regNumber){
            this.age = age;
            this.name = name;
            this.regNumber = regNumber;
        }
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegNumber() {
            return regNumber;
        }

        public void setRegNumber(String regNumber) {
            this.regNumber = regNumber;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", regNumber='" + regNumber + '\'' +
                    '}';
        }
    }
    public static void main(String args[]){
        List<Person> persons = List.of(
            new Person(10, "noyon", "1235"),
            new Person(10, "noyon", "1236"),
            new Person(10, "noyon", "1234")
        );

        persons.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName)
                        .thenComparing(Person::getRegNumber))
                .forEach(System.out::println);

        persons.stream()
                .map(person -> person.getRegNumber())
                .sorted()
                .forEachOrdered(person -> System.out.println(person));

        String[] numbers = {"one", "two", "four", "three"};
        Stream.of(numbers).parallel().sorted()
                .forEachOrdered(number -> System.out.print(number + " "));
        System.out.println();
    }
}
