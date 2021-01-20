package com.bogdan.model;

import java.util.Set;

public class Student {

    private int id;
    private String name;
    private String info;
    private Set<Course> courses;

    public Student(int id, String name, String info, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.info = info;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
