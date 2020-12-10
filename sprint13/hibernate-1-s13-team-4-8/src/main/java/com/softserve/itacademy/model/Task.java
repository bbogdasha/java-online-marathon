package com.softserve.itacademy.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "task_sequence"),
                    @Parameter(name = "initial_value", value = "6"),
                    @Parameter(name = "increment_size", value = "1")
            })
    private long id;

    @NotBlank(message = "Name may not be blank")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Priority may not be null")
    private Priority priority;

    @ManyToOne(optional = false)
    @JoinColumn(name = "state_id", referencedColumnName="id", insertable=false, updatable=false)
    private State state;

    @ManyToOne(optional = false)
    @JoinColumn(name = "todo_id", referencedColumnName="id", insertable=false, updatable=false)
    private ToDo toDo;

    public Task() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ToDo getToDo() {
        return toDo;
    }

    public void setToDo(ToDo toDo) {
        this.toDo = toDo;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", state=" + state +
                ", toDo=" + toDo +
                '}';
    }
}
