package com.softserve.itacademy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.itacademy.model.ToDo;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.ToDoService;
import com.softserve.itacademy.service.UserService;

@Service
public class ToDoServiceImpl implements ToDoService {

    private UserService userService;

    @Autowired
    public ToDoServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ToDo addTodo(ToDo todo, User user) {
        boolean statusUser = userService.getAll().stream().anyMatch(u -> u.getEmail().equals(user.getEmail()));
        if (statusUser) {
            boolean statusToDo = user.getMyTodos().stream().anyMatch(td -> td.getTitle().equals(todo.getTitle()));
            if (!statusToDo) {
                user.getMyTodos().add(todo);
                return todo;
            }
        }
        return null;
    }

    @Override
    public ToDo updateTodo(ToDo todo) {
        for (ToDo td : todo.getOwner().getMyTodos()) {
            if (td.getTitle().equals(todo.getTitle())) {
                td.setTasks(todo.getTasks());
                td.setCreatedAt(todo.getCreatedAt());
                return td;
            }
        }
        return null;
    }

    @Override
    public void deleteTodo(ToDo todo) {
        todo.getOwner().getMyTodos().remove(todo);
    }

    @Override
    public List<ToDo> getAll() {
        List<ToDo> list = new ArrayList<>();
        for (User user : userService.getAll()) {
            list.addAll(user.getMyTodos());
        }
        return list;
    }

    @Override
    public List<ToDo> getByUser(User user) {
        return user.getMyTodos();
    }

    @Override
    public ToDo getByUserTitle(User user, String title) {
        for (ToDo tD : user.getMyTodos()) {
            if (tD.getTitle().equals(title)) {
                return tD;
            }
        }
        return null;
    }
}
