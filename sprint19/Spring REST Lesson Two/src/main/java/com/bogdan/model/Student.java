package com.bogdan.model;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {

    private static final AtomicInteger counter = new AtomicInteger();
    private int id;
    private String name;
    private String surname;
    private Set<Course> courses;

    public Student(String name, String surname, Set<Course> courses) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.surname = surname;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
