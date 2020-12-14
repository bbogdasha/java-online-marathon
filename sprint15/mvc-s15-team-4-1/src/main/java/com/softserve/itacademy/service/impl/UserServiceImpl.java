package com.softserve.itacademy.service.impl;

import com.softserve.itacademy.model.User;
import com.softserve.itacademy.repository.UserRepository;
import com.softserve.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
            return userRepository.save(user);
    }

    @Override
    public User readById(long id) {
        Optional<User> optional = userRepository.findById(id);
            return optional.get();
    }

    @Override
    public User update(User user) {
        User newUser = readById(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setRole(user.getRole());
        newUser.setMyTodos(user.getMyTodos());
        newUser.setOtherTodos(user.getOtherTodos());
        return userRepository.save(newUser);
    }

    @Override
    public void delete(long id) {
        User user = readById(id);
            userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ? new ArrayList<>() : users;
    }

}
