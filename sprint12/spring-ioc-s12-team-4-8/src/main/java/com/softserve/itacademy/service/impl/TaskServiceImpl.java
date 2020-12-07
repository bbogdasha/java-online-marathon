package com.softserve.itacademy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.model.ToDo;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.TaskService;
import com.softserve.itacademy.service.ToDoService;

@Service
public class TaskServiceImpl implements TaskService {

    private final ToDoService toDoService;

    @Autowired
    public TaskServiceImpl(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @Override
    public Task addTask(Task task, ToDo todo) {
        boolean statusToDo = toDoService.getAll().stream().anyMatch(td -> td.getTitle().equals(todo.getTitle()));
        if (statusToDo) {
            boolean statusTask = todo.getTasks().stream().anyMatch(t -> t.getName().equals(task.getName()));
            if (!statusTask) {
                todo.getTasks().add(task);
                return task;
            }
        }
        return null;
    }

    @Override
    public Task updateTask(Task task) {
        for (Task t : getAll()) {
            if (t.getName().equals(task.getName())) {
                t.setPriority(task.getPriority());
                return t;
            }
        }
        return null;
    }

    @Override
    public void deleteTask(Task task) {
        for (ToDo td : toDoService.getAll()) {
            td.getTasks().remove(task);
        }
    }

    @Override
    public List<Task> getAll() {
        List<Task> list = new ArrayList<>();
        for (ToDo toDo : toDoService.getAll()) {
            list.addAll(toDo.getTasks());
        }
        return list;
    }

    @Override
    public List<Task> getByToDo(ToDo todo) {
        return todo.getTasks();
    }

    @Override
    public Task getByToDoName(ToDo todo, String name) {
        for (Task t : todo.getTasks()) {
            if (t.getName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Task getByUserName(User user, String name) {
        for (ToDo td : user.getMyTodos()) {
            for (Task t : td.getTasks()) {
                if (t.getName().equals(name)) {
                    return t;
                }
            }
        }
        return null;
    }
}