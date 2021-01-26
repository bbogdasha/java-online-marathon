package com.bogdan.model;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Course {

    private static final AtomicInteger counter = new AtomicInteger();
    private int id;
    private String name;
    private String info;
    private List<String> steps;

    public Course(String name, String info, List<String> steps) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.info = info;
        this.steps = steps;
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

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                name.equals(course.name) &&
                info.equals(course.info) &&
                steps.equals(course.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, info, steps);
    }
}
