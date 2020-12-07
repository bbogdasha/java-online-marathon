package com.softserve.itacademy.model;

import java.util.List;
import java.util.Objects;

public class User {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private List<ToDo> myTodos;

    // Constructor(s), getters, setters, hashCode, equals, etc.

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, List<ToDo> myTodos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.myTodos = myTodos;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ToDo> getMyTodos() {
        return myTodos;
    }

    public void setMyTodos(List<ToDo> myTodos) {
        this.myTodos = myTodos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                myTodos.equals(user.myTodos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password, myTodos);
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", myTodos=" + myTodos +
                '}';
    }
}
