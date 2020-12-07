package com.softserve.itacademy.model;

import java.util.Objects;

public class Task {

    private String name;

    private Priority priority;

    // Constructor(s), getters, setters, hashCode, equals, etc.

    public Task(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return name.equals(task.name) &&
                priority == task.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priority);
    }

    @Override
    public String toString() {
        return "\nTask{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
