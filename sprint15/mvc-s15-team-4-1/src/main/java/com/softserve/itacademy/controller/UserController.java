package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.model.ToDo;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.TaskService;
import com.softserve.itacademy.service.ToDoService;
import com.softserve.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ToDoService toDoService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/users/all";
    }

    @GetMapping("/read/{id}")
    public String read(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.readById(id);
        return "user-info";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.readById(id));
        return "update-user";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        User oldUser = userService.readById(user.getId());
        if (oldUser.getPassword().equals(user.getPassword())) {
            userService.update(user);
        }
        return "redirect:/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users-list";
    }
}
