package com.mat.todo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "tasks_group")
public class TasksGroup {

    @Id
    private int id;
    @NotBlank(message = "Tasks group description must not be null or empty!")
    private String title;
    private boolean completed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> tasks;

    public TasksGroup() {
    }

    int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    boolean isCompleted() {
        return completed;
    }

    void setCompleted(final boolean completed) {
        this.completed = completed;
    }

    Set<Task> getTasks() {
        return tasks;
    }
}