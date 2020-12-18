package com.softserve.itacademy.controller;

import com.softserve.itacademy.dto.TaskDto;
import com.softserve.itacademy.dto.TaskTransformer;
import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.repository.UserRepository;
import com.softserve.itacademy.service.StateService;
import com.softserve.itacademy.service.TaskService;
import com.softserve.itacademy.service.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final ToDoService todoService;
    private final StateService stateService;
    private final UserRepository userRepository;

    public TaskController(TaskService taskService, ToDoService todoService, StateService stateService, UserRepository userRepository) {
        this.taskService = taskService;
        this.todoService = todoService;
        this.stateService = stateService;
        this.userRepository = userRepository;
    }

    @GetMapping("/create/todos/{todo_id}")
    public String create(@PathVariable("todo_id") long todoId, Model model, Principal principal) {
        User user = userRepository.getUserByEmail(principal.getName());
        if (todoService.readById(todoId).getOwner().getEmail().equals(principal.getName()) || user.getRole().getName().equals("ADMIN")) {
            model.addAttribute("task", new TaskDto());
            model.addAttribute("todo", todoService.readById(todoId));
            model.addAttribute("priorities", Priority.values());
            return "create-task";
        }
        return "redirect:/accessDenied";
    }

    @PostMapping("/create/todos/{todo_id}")
    public String create(@PathVariable("todo_id") long todoId, Model model,
                         @Validated @ModelAttribute("task") TaskDto taskDto, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("todo", todoService.readById(todoId));
            model.addAttribute("priorities", Priority.values());
            return "create-task";
        }
        Task task = TaskTransformer.convertToEntity(
                taskDto,
                todoService.readById(taskDto.getTodoId()),
                stateService.getByName("New")
        );
        taskService.create(task);
        return "redirect:/todos/" + todoId + "/tasks";
    }

    @GetMapping("/{task_id}/update/todos/{todo_id}")
    public String update(@PathVariable("task_id") long taskId, @PathVariable("todo_id") long todoId, Model model, Principal principal) {
        User user = userRepository.getUserByEmail(principal.getName());
        if (taskService.readById(taskId).getTodo().getOwner().getEmail().equals(principal.getName()) || user.getRole().getName().equals("ADMIN")) {
            TaskDto taskDto = TaskTransformer.convertToDto(taskService.readById(taskId));
            model.addAttribute("task", taskDto);
            model.addAttribute("priorities", Priority.values());
            model.addAttribute("states", stateService.getAll());
            return "update-task";
        }
        return "redirect:/accessDenied";
    }

    @PostMapping("/{task_id}/update/todos/{todo_id}")
    public String update(@PathVariable("task_id") long taskId, @PathVariable("todo_id") long todoId, Model model,
                         @Validated @ModelAttribute("task")TaskDto taskDto, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("priorities", Priority.values());
            model.addAttribute("states", stateService.getAll());
            return "update-task";
        }
        Task task = TaskTransformer.convertToEntity(
                taskDto,
                todoService.readById(taskDto.getTodoId()),
                stateService.readById(taskDto.getStateId())
        );
        taskService.update(task);
        return "redirect:/todos/" + todoId + "/tasks";
    }

    @GetMapping("/{task_id}/delete/todos/{todo_id}")
    public String delete(@PathVariable("task_id") long taskId, @PathVariable("todo_id") long todoId, Principal principal) {
        User user = userRepository.getUserByEmail(principal.getName());
        if (taskService.readById(taskId).getTodo().getOwner().getEmail().equals(principal.getName()) || user.getRole().getName().equals("ADMIN")) {
            taskService.delete(taskId);
            return "redirect:/todos/" + todoId + "/tasks";
        }
        return "redirect:/accessDenied";
    }
}
