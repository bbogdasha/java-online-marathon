package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.service.StateService;
import com.softserve.itacademy.service.TaskService;
import com.softserve.itacademy.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    ToDoService toDoService;
    @Autowired
    StateService stateService;

    @GetMapping("/create/todos/{todo_id}")
    public String create(@PathVariable("todo_id") int todo_id, Model model) {
        model.addAttribute("priorities", Priority.values());
        model.addAttribute("todo_id", todo_id);
        return "create-task";
    }

    @PostMapping("/create/todos/{todo_id}")
    public String create(@ModelAttribute(name = "task") Task task,
                         @PathVariable("todo_id") int todo_id) {
        task.setTodo(toDoService.readById(todo_id));
        task.setState(stateService.readById(5));
        taskService.create(task);
        return "redirect:/todos/" + todo_id + "/tasks";
    }

    @GetMapping("/{task_id}/update/todos/{todo_id}")
    public String update(@PathVariable("todo_id") int todo_id,
                         @PathVariable("task_id") int task_id,
                             Model model) {
        Iterable<Task> tasks = taskService.getByTodoId(todo_id);
        for (Task task : tasks) {
            if (task.getId() == task_id) {
                model.addAttribute("task", task);
                model.addAttribute("priorities", Priority.values());
                model.addAttribute("states", stateService.getAll());
            }
        }
        return "update-task";
    }

    @PostMapping("/{task_id}/update/todos/{todo_id}")
    public String update(@ModelAttribute(name = "taskUpdate") Task task,
                         @PathVariable("todo_id") int todo_id,
                         @PathVariable("task_id") int task_id) {
        Task oldTask = taskService.readById(task_id);
        oldTask.setName(task.getName());
        oldTask.setPriority(task.getPriority());
        oldTask.setState(task.getState());
        taskService.update(oldTask);
        return "redirect:/todos/" + todo_id + "/tasks";
    }

    @GetMapping("/{task_id}/delete/todos/{todo_id}")
    public String delete(@PathVariable("todo_id") int todo_id,
                         @PathVariable("task_id") int task_id) {
        taskService.delete(task_id);
        return "redirect:/todos/" + todo_id + "/tasks";
    }
}
