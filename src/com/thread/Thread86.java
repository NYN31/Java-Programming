package com.thread;

import java.util.Collections;
import java.util.List;

public class Thread86 {
    private final String name;
    private final int age;
    private final List<String> friends;

    public Thread86(String name, int age, List<String>  friends){
        this.name = name;
        this.age = age;
        this.friends = friends;
    }
    public String getName(){
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFriends() {
        return Collections.unmodifiableList(this.friends);
    }
}
