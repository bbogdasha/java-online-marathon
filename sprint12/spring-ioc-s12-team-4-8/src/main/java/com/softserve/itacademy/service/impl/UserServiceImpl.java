package com.softserve.itacademy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl() {
        users = new ArrayList<>();
    }

    @Override
    public User addUser(User user) {
        boolean status = users.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()));
        if (!status) {
            users.add(user);
            return user;
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail())) {
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                u.setPassword(user.getPassword());
                u.setMyTodos(user.getMyTodos());
                return u;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
