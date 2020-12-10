package com.softserve.itacademy.repository;

import com.softserve.itacademy.model.Task;

import java.util.LinkedList;
import java.util.List;

public class TaskRepository {

    private List<Task> tasks = new LinkedList<>();

    private static TaskRepository taskRepository = null;

    public TaskRepository() {
    }

    public static TaskRepository getTaskRepository() {
        if (taskRepository == null) {
            taskRepository = new TaskRepository();
            return taskRepository;
        }
        return taskRepository;
    }

    public boolean create(Task task) {
        boolean status = tasks.stream().anyMatch(t -> t.getTitle().equals(task.getTitle()));
        if (!status) {
            return tasks.add(task);
        }
        return false;
    }

    public Task read(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    public boolean update(Task task, int id) {
        int index = tasks.indexOf(read(id));
        return tasks.set(index, task) != null;
    }

    public boolean delete(int id) {
        Task task = read(id);
        if (task != null) {
            return tasks.remove(task);
        }
        return false;
    }

    public List<Task> all() {
        return tasks;
    }
}
