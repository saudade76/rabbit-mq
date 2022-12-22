package com.rabbitmq.example.model;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    private long id;
    private String name;
    private int age;
    private String address;
    private String tel;

    public Student(long id, String name, int age, String address, String tel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
