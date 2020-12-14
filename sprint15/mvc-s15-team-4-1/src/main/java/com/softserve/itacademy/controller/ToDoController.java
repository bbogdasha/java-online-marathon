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

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    TaskService taskService;
    @Autowired
    ToDoService toDoService;
    @Autowired
    UserService userService;

    @GetMapping("/create/users/{owner_id}")
    public String create(@PathVariable("owner_id") int owner_id, Model model) {
        model.addAttribute("owner_id", owner_id);
        return "create-todo";
    }

    @PostMapping("/create/users/{owner_id}")
    public String create(@ModelAttribute(name = "todo") ToDo toDo,
                         @PathVariable("owner_id") int owner_id) {
        toDo.setOwner(userService.readById(owner_id));
        toDo.setCreatedAt(LocalDateTime.now());
        toDoService.create(toDo);
        return "redirect:/todos/all/users/" + owner_id;
    }

    @GetMapping("/{id}/tasks")
    public String read(@PathVariable(name = "id") Integer id, Model model) {
        Iterable<Task> tasks = taskService.getByTodoId(id);
        model.addAttribute("todo", "All Tasks From " + toDoService.readById(id).getTitle());
        model.addAttribute("owner_id", toDoService.readById(id).getOwner().getId());
        model.addAttribute("todo_id", id);
        model.addAttribute("tasks", tasks);

        List<User> allUsers = userService.getAll();
        List<User> allCollab = toDoService.readById(id).getCollaborators();
        allUsers.removeAll(new HashSet<>(allCollab));
        allUsers.remove(toDoService.readById(id).getOwner());
        model.addAttribute("notCollaborators", allUsers);
        model.addAttribute("collaborators", allCollab);
        return "todo-tasks";
    }

    @GetMapping("/{todo_id}/update/users/{owner_id}")
    public String update(@PathVariable("todo_id") int todo_id,
                         @PathVariable("owner_id") int owner_id,
                         Model model) {
        model.addAttribute("todo", toDoService.readById(todo_id));
        model.addAttribute("owner_id", owner_id);
        return "update-todo";
    }

    @PostMapping("/{todo_id}/update/users/{owner_id}")
    public String update(@ModelAttribute(name = "todoUpdate") ToDo toDo,
                         @PathVariable("todo_id") int todo_id,
                         @PathVariable("owner_id") int owner_id) {
        ToDo oldToDo = toDoService.readById(todo_id);
        oldToDo.setTitle(toDo.getTitle());
        toDoService.update(oldToDo);
        return "redirect:/todos/all/users/" + owner_id;
    }

    @GetMapping("/{todo_id}/delete/users/{owner_id}")
    public String delete(@PathVariable("todo_id") int todo_id,
                         @PathVariable("owner_id") int owner_id) {
        toDoService.delete(todo_id);
        return "redirect:/todos/all/users/" + owner_id;
    }

    @GetMapping("/all/users/{user_id}")
    public String getAll(@PathVariable(name = "user_id") Integer id, Model model) {
        Iterable<ToDo> toDos = toDoService.getByUserId(id);
        model.addAttribute("user", "All ToDo List of " + userService.readById(id).getFirstName() + " " + userService.readById(id).getLastName());
        model.addAttribute("owner_id", id);
        model.addAttribute("todos", toDos);
        return "todos-user";
    }

    @PostMapping("/{id}/add")
    public String addCollaborator(@ModelAttribute(name = "collab") User user,
                                  @PathVariable("id") int todo_id) {
        System.out.println(user);
        for (User u : userService.getAll()) {
            if (u.getId() == user.getId()) {
                System.out.println("USER: " + u.getId() + " " + u.getFirstName());
                System.out.println("COLLAB: " + user.getId() + " " + user.getFirstName());
                ToDo toDo = toDoService.readById(todo_id);
                List<User> collaborators = toDo.getCollaborators();
                collaborators.add(u);
                toDo.setCollaborators(collaborators);
                toDoService.update(toDo);
            }
        }
        return "redirect:/todos/" + todo_id + "/tasks";
    }

    @GetMapping("/{id}/remove")
    public String removeCollaborator(@PathVariable("id") int todo_id) {

        return "redirect:/todos/" + todo_id + "/tasks";
    }
}
