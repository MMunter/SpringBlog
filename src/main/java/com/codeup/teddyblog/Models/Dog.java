package com.codeup.teddyblog.Models;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "INT(11) unsigned")
    private int id;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String name;

    @Column(name="reside_state", nullable = false, length = 2)
    private String resideState;

    public Dog(int id, int age, String name, String resideState){
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public Dog(int age, String name, String resideState){
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public Dog(String name, String resideState){
        this.name = name;
        this.resideState = resideState;
    }

    public Dog(){}


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

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
