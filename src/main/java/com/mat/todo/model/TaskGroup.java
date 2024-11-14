package com.mat.todo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "task_groups")
public class TaskGroup {

    @Id
    private int id;
    @NotBlank(message = "Tasks group description must not be null or empty!")
    private String title;
    private boolean completed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> tasks;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public TaskGroup() {
    }

    int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    boolean isCompleted() {
        return completed;
    }

    void setCompleted(final boolean completed) {
        this.completed = completed;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(final Set<Task> tasks) {
        this.tasks = tasks;
    }

    Project getProject() {
        return project;
    }

    void setProject(final Project project) {
        this.project = project;
    }
}