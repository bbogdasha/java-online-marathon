package com.softserve.itacademy;

import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.model.ToDo;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.ToDoService;
import com.softserve.itacademy.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoServiceTest {

    private static ToDoService toDoService;
    private static UserService userService;

    @BeforeAll
    public static void setupBeforeClass() throws Exception {
        AnnotationConfigApplicationContext annotationConfigContext = new AnnotationConfigApplicationContext(Config.class);
        toDoService = annotationConfigContext.getBean(ToDoService.class);
        userService = annotationConfigContext.getBean(UserService.class);
        annotationConfigContext.close();
    }

    @Test
    public void checkAddToDo() {
        List<ToDo> toDos = new ArrayList<>();
        User user = new User("Alice", "First", "Alice@com", "252525", toDos);
        userService.addUser(user);
        ToDo todo = new ToDo("Main", LocalDateTime.now().withNano(0), user, new ArrayList<>());
        ToDo expected = new ToDo("Main", LocalDateTime.now().withNano(0), user, new ArrayList<>());
        ToDo actual = toDoService.addTodo(todo, user);
        Assertions.assertEquals(expected, actual, "check message");
    }

    @Test
    public void checkAddToDoWithExistTitle() {
        List<ToDo> toDos = new ArrayList<>();
        User user = new User("Alice", "First", "Alice@com", "252525", toDos);
        userService.addUser(user);
        ToDo todo = new ToDo("Main", LocalDateTime.now().withNano(0), user, new ArrayList<>());
        toDoService.addTodo(todo, user);
        ToDo duplicateTodo = new ToDo("Main", LocalDateTime.now().withNano(0), user, new ArrayList<>());
        ToDo expected = null;
        ToDo actual = toDoService.addTodo(duplicateTodo, user);
        Assertions.assertEquals(expected, actual, "check message");
    }

    @Test
    public void checkUpdateToDo() {
        List<ToDo> toDos = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        List<Task> newTasks = new ArrayList<>();
        User user = new User("Alice", "First", "Alice@com", "252525", toDos);
        userService.addUser(user);
        ToDo todo = new ToDo("Main", LocalDateTime.now().withNano(0), user, tasks);
        toDoService.addTodo(todo, user);
        ToDo newTodo = new ToDo("Main", LocalDateTime.now().withNano(0), user, newTasks);
        ToDo expected = new ToDo("Main", LocalDateTime.now().withNano(0), user, newTasks);
        ToDo actual = toDoService.updateTodo(newTodo);
        Assertions.assertEquals(expected, actual, "check message");
    }

    @Test
    public void checkUpdateToDoWhichNotExist() {
        List<ToDo> toDos = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        List<Task> newTasks = new ArrayList<>();
        User user = new User("Alice", "First", "Alice@com", "252525", toDos);
        userService.addUser(user);
        ToDo todo = new ToDo("Main", LocalDateTime.now().withNano(0), user, tasks);
        toDoService.addTodo(todo, user);
        ToDo newTodo = new ToDo("main", LocalDateTime.now().withNano(0), user, newTasks);
        ToDo expected = null;
        ToDo actual = toDoService.updateTodo(newTodo);
        Assertions.assertEquals(expected, actual, "check message");
    }

    @Test
    public void checkDeleteToDo() {
        List<ToDo> toDos = new ArrayList<>();
        User user = new User("Alice", "First", "Alice@com", "252525", toDos);
        userService.addUser(user);
        ToDo todo = new ToDo("Main", LocalDateTime.now().withNano(0), user, new ArrayList<>());
        toDoService.addTodo(todo, user);
        toDoService.deleteTodo(todo);
        Assertions.assertEquals(toDoService.getAll().size(), 0, "check message");
    }

    @Test
    public void checkGetAll() {
        List<ToDo> toDos = new ArrayList<>();
        User user = new User("TestGetAll", "GetAll", "getAll@com", "010101", toDos);
        userService.addUser(user);
        ToDo todo = new ToDo("GetAll", LocalDateTime.now().withNano(0), user, new ArrayList<>());
        toDoService.addTodo(todo, user);
        Assertions.assertEquals(toDoService.getAll().size(), 1, "check message");
    }
}
