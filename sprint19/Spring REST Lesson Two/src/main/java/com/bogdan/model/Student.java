package com.bogdan.model;

import java.util.Set;

public class Student {

    private int id;
    private String name;
    private String surname;
    private Set<Course> courses;

    public Student(int id, String name, String surname, Set<Course> courses) {
        this.id = id;
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
