package com.softserve.itacademy.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "users_sequence"),
                    @Parameter(name = "initial_value", value = "5"),
                    @Parameter(name = "increment_size", value = "1")
            })
    private long id;

    @Column(name = "first_name", nullable = false)
    @Pattern(regexp = "^[A-Z][a-z]+([-][A-Z][a-z]+)|^[A-Z][a-z]+", message = "Name must be valid")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Pattern(regexp = "^[A-Z][a-z]+([-][A-Z][a-z]+)|^[A-Z][a-z]+", message = "Surname must be valid")
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email(message = "Email should be valid")
    @NotBlank
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Password may not be blank")
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", referencedColumnName="id", insertable=false, updatable=false)
    private Role role;

    @OneToMany(mappedBy = "owner")
    private List<ToDo> toDos;

    @ManyToMany
    @JoinTable(
            name = "todo_collaborator",
            joinColumns = @JoinColumn(name = "collaborator_id", referencedColumnName = "id"),
            inverseJoinColumns=@JoinColumn(name = "todo_id", referencedColumnName = "id"))
    private List<ToDo> toDoList;

    public User() {
    }

    public long getId() {
        return id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
