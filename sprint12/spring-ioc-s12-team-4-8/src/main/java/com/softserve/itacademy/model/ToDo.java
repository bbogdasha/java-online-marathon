package com.softserve.itacademy.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ToDo {

    private String title;

    private LocalDateTime createdAt;

    private User owner;

    private List<Task> tasks;

    // Constructor(s), getters, setters, hashCode, equals, etc.

    public ToDo(String title, LocalDateTime createdAt, User owner, List<Task> tasks) {
        this.title = title;
        this.createdAt = createdAt;
        this.owner = owner;
        this.tasks = tasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return title.equals(toDo.title) &&
                createdAt.equals(toDo.createdAt) &&
                owner.equals(toDo.owner) &&
                tasks.equals(toDo.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, createdAt, owner, tasks);
    }

    @Override
    public String toString() {
        return "\nToDo{" +
                "title='" + title + '\'' +
                ", createdAt=" + createdAt +
                ", tasks=" + tasks +
                '}';
    }
}