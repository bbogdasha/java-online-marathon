package com.bogdan.model;

import java.util.List;
import java.util.Objects;

public class Course {

    private String name;
    private String info;
    private List<String> steps;

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
        return name.equals(course.name) &&
                info.equals(course.info) &&
                steps.equals(course.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, info, steps);
    }
}