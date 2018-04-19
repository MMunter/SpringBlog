package com.codeup.teddyblog.Models;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 2)
    private String reside_state;

    public Person(int id, int age, String name, String reside_state){
        this.id = id;
        this.age = age;
        this.name = name;
        this.reside_state = reside_state;
    }

    public Person(int age, String name, String reside_state){
        this.age = age;
        this.name = name;
        this.reside_state = reside_state;
    }

    public Person(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getReside_state() {
        return reside_state;
    }

    public void setReside_state(String reside_state) {
        this.reside_state = reside_state;
    }
}
