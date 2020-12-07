package com.softserve.itacademy;

import com.softserve.itacademy.model.Priority;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.model.ToDo;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.TaskService;
import com.softserve.itacademy.service.ToDoService;
import com.softserve.itacademy.service.UserService;
import com.softserve.itacademy.service.impl.TaskServiceImpl;
import com.softserve.itacademy.service.impl.ToDoServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskServiceTest {

    private static TaskService taskService;
    private static ToDoService toDoService;
    private static UserService userService;

    @BeforeAll
    public static void setupBeforeClass() throws Exception {
        AnnotationConfigApplicationContext annotationConfigContext = new AnnotationConfigApplicationContext(Config.class);
        userService = annotationConfigContext.getBean(UserService.class);
        toDoService = annotationConfigContext.getBean(ToDoService.class);
        taskService = annotationConfigContext.getBean(TaskService.class);
        annotationConfigContext.close();
    }

    @Test
    public void checkAddTask() {
        toDoService = new ToDoServiceImpl(userService);
        taskService = new TaskServiceImpl(toDoService);
        Task task = new Task("Name 1", Priority.HIGH);
        List<Task> taskList = new ArrayList<>();
        User user = new User("Alice", "First", "Alice@com", "252525", new ArrayList<>());
        userService.addUser(user);
        ToDo toDo = new ToDo("Title ToDo List",  LocalDateTime.now(), user, taskList);
        toDoService.addTodo(toDo, user);
        taskService.addTask(task, toDo);
        Assert.assertTrue(taskService.getAll().contains(task));
    }

    @Test
    public void checkAddTaskWithExistName() {
        List<Task> tasks = new ArrayList<>();
        List<ToDo> toDosForTask = new ArrayList<>();
        User userForTask = new User("UserNotAddTask", "UserNotAddTask", "UserNotAddTask@com", "252525", toDosForTask);
        ToDo todoForTask = new ToDo("TodoNotAddTask", LocalDateTime.now().withNano(0), userForTask, tasks);
        userService.addUser(userForTask);
        toDoService.addTodo(todoForTask, userForTask);
        Task task = new Task("TaskNotAdd", Priority.HIGH);
        taskService.addTask(task, todoForTask);
        Task duplicateTask = new Task("TaskNotAdd", Priority.HIGH);
        Task expected = null;
        Task actual = taskService.addTask(duplicateTask, todoForTask);
        Assertions.assertEquals(expected, actual, "check message");
    }

    @Test
    public void checkUpdateTask() {
        List<Task> taskList1 = new ArrayList<>();
        taskList1.add(new Task("Task 1", Priority.LOW));
        taskList1.add(new Task("Task 2", Priority.MEDIUM));
        taskList1.add(new Task("Task 3", Priority.HIGH));
        Task changeableTask = new Task("Task 4", Priority.MEDIUM);
        taskList1.add(changeableTask);
        User user = new User("newAlice", "newFirst", "Alic@com", "new252525", new ArrayList<>());
        userService.addUser(user);
        ToDo toDo = new ToDo("Changeable ToDo", LocalDateTime.now(), user, taskList1);
        toDoService.addTodo(toDo, user);
        taskService.addTask(changeableTask, toDo);
        Task newTask = taskService.updateTask(changeableTask);
        Assert.assertTrue(taskService.getAll().contains(newTask));
    }

    @Test
    public void checkUpdateTaskWhichNotExist() {
        List<Task> tasks = new ArrayList<>();
        List<ToDo> toDosForTask = new ArrayList<>();
        User userForTask = new User("UserNotUpTask", "UserNotUpTask", "UserNotUpTask@com", "252525", toDosForTask);
        ToDo todoForTask = new ToDo("TodoNotUpTask", LocalDateTime.now().withNano(0), userForTask, tasks);
        userService.addUser(userForTask);
        toDoService.addTodo(todoForTask, userForTask);
        Task task = new Task("TaskNotUp", Priority.HIGH);
        taskService.addTask(task, todoForTask);
        Task newTask = new Task("TaskNotUp11", Priority.LOW);
        Task expected = null;
        Task actual = taskService.updateTask(newTask);
        Assertions.assertEquals(expected, actual, "check message");
    }

    @Test
    public void checkDeleteTask() {
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Task 1", Priority.LOW));
        taskList.add(new Task("Task 2", Priority.MEDIUM));
        taskList.add(new Task("Task 3", Priority.HIGH));
        Task deleteTask = new Task("Task 4", Priority.MEDIUM);
        taskList.add(deleteTask);
        ToDo toDo = new ToDo("Delete ToDo", LocalDateTime.now(), new User(), taskList);
        taskService.deleteTask(deleteTask);
        Assert.assertTrue(!taskService.getAll().contains(deleteTask));
    }

    @Test
    public void checkGetAll() {
        List<Task> taskList1 = new ArrayList<>();
        taskList1.add(new Task("Task 1", Priority.LOW));
        taskList1.add(new Task("Task 2", Priority.MEDIUM));
        taskList1.add(new Task("Task 3", Priority.HIGH));
        taskList1.add(new Task("Task 4", Priority.MEDIUM));
        ToDo toDo1 = new ToDo("List ToDo 1", LocalDateTime.now(), new User(), taskList1);
        List<Task> taskList2 = new ArrayList<>();
        taskList2.add(new Task("Task 5", Priority.LOW));
        taskList2.add(new Task("Task 6", Priority.MEDIUM));
        taskList2.add(new Task("Task 7", Priority.HIGH));
        taskList2.add(new Task("Task 8", Priority.MEDIUM));
        ToDo toDo2 = new ToDo("List ToDo 2", LocalDateTime.now(), new User(), taskList2);
        List<Task> checkList = taskService.getAll();
        Assert.assertTrue(!checkList.isEmpty());
    }
}
