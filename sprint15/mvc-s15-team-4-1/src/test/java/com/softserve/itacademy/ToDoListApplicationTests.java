package com.softserve.itacademy;

import com.softserve.itacademy.model.ToDo;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.ToDoService;
import com.softserve.itacademy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class ToDoListApplicationTests {

    @Autowired
    ToDoService toDoService;
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
//        List<User> allUsers = userService.getAll();
//        List<User> allCollab = toDoService.readById(7).getCollaborators();
//        allUsers.removeAll(new HashSet<>(allCollab));
//        for (User user : allUsers) {
//            System.out.println("User after: " + user.getId());
//        }

        ToDo toDo = toDoService.readById(7);
        User user = userService.readById(7);
        List<User> collaborators = toDo.getCollaborators();
        collaborators.add(user);
        toDo.setCollaborators(collaborators);
        toDoService.update(toDo);
        for (User u : toDoService.readById(7).getCollaborators()) {
            System.out.println("User after: " + u.getFirstName());
        }
    }
}
