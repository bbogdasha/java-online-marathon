package com.softserve.itacademy;

import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class UserServiceTest {

    private static UserService userService;

    @BeforeAll
    public static void setupBeforeClass() throws Exception {
        AnnotationConfigApplicationContext annotationConfigContext = new AnnotationConfigApplicationContext(Config.class);
        userService = annotationConfigContext.getBean(UserService.class);
        annotationConfigContext.close();

        User user1 = new User("Test1", "A", "testA@com", "121212", new ArrayList<>());
        User user2 = new User("Test2", "B", "testB@com", "232323", new ArrayList<>());
        User user3 = new User("Test3", "C", "testC@com", "343434", new ArrayList<>());
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
    }

    @Test
    public void checkAddUser() {
        User user = new User("Alice", "First", "Alice@com", "252525", new ArrayList<>());
        User expected = new User("Alice", "First", "Alice@com", "252525", new ArrayList<>());
        User actual = userService.addUser(user);
        Assertions.assertEquals(expected, actual, "check message");
    }

    @Test
    public void checkAddUserWithExistEmail() {
        User user = new User("newAlice", "newFirst", "Alice@com", "new252525", new ArrayList<>());
        User expected = null;
        User actual = userService.addUser(user);
        Assertions.assertEquals(expected, actual, "check message");
    }

    @Test
    public void checkUpdateUserByEmail() {
        User user = new User("John", "Big", "John@com", "545454", new ArrayList<>());
        userService.addUser(user);
        user = new User("Jonny", "Little", "John@com", "111111", new ArrayList<>());
        User expected = new User("Jonny", "Little", "John@com", "111111", new ArrayList<>());
        User actual = userService.updateUser(user);
        Assertions.assertEquals(expected, actual, "check message");
    }

    @Test
    public void checkUpdateUserWhichNotExist() {
        User user = new User("Den", "Denny", "Den@com", "222222", new ArrayList<>());
        User expected = null;
        User actual = userService.updateUser(user);
        Assertions.assertEquals(expected, actual, "check message");
    }

    @Test
    public void checkDeleteUser() {
        User user = new User("Test2", "B", "testB@com", "232323", new ArrayList<>());
        userService.deleteUser(user);
        Assertions.assertEquals(userService.getAll().size(), 2, "check message");
    }

    @Test
    public void checkGetAll() {
        Assertions.assertEquals(userService.getAll().size(), 4, "check message");
    }
}
