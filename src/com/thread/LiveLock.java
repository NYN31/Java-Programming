package com.thread;

public class LiveLock {
    public static class Corridor {
        private Person owner;

        public Corridor(Person owner) {
            this.owner = owner;
        }

        public Person getOwner() {
            return owner;
        }

        public synchronized void setOwner(Person owner) {
            this.owner = owner;
        }
    }
    public static class Person{
        private String name;
        private boolean active;

        public Person(String name, boolean active){
            this.name = name;
            this.active = active;
        }

        public String getName(){
            return name;
        }

        public boolean isActive(){
            return active;
        }

        public synchronized void work(Corridor corridor, Person otherPerson){
            while(active){
                // wait for the resource to become available
                if(corridor.getOwner() != this){
                    try{
                        wait(10);
                    } catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                        throw new AssertionError(e);
                    }
                    continue;
                }

                // if other worker is also active let it do it's work first
                if(otherPerson.isActive()){
                    System.out.println(getName() + ": handover the corridor to the person "
                     + otherPerson.getName());
                    corridor.setOwner(otherPerson);
                    continue;
                }

                // now use the corridor
                System.out.println(getName() + ": working on the corridor");
                active = false;
                corridor.setOwner(otherPerson);
            }
        }
    }

    public static void main(String[] args){
        final Person person1 = new Person("Person #1", true);
        final Person person2 = new Person("Person #2", true);

        final Corridor s = new Corridor(person1);

        new Thread(() -> {
            person1.work(s, person2);
        }).start();
        new Thread(() -> {
            person2.work(s, person1);
        }).start();
    }
}
