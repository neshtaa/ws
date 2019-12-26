package main.java;

import java.util.concurrent.atomic.AtomicInteger;

public class Human {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String name;
    private int age;
    private typeOfHuman type = typeOfHuman.COMMON;

    public Human(String _name, int _age) {
        id = count.incrementAndGet();
        name = _name;
        age = _age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public typeOfHuman getType() {
        return type;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void setType(typeOfHuman type) {
        this.type = type;
    }
}
