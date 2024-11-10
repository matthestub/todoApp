package com.mat.todo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean done;
    @NotBlank(message = "Task description must not be null or empty!")
    private String description;
    private LocalDateTime dueDate;
    @Embedded
    private Audit audit = new Audit();
    @ManyToOne
    @JoinColumn(name = "tasks_group_id")
    private TasksGroup group;

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    void setDueDate(final LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    TasksGroup getGroup() {
        return group;
    }

    public void updateFrom(Task source) {
        this.done = source.isDone();
        this.description = source.getDescription();
        this.dueDate = source.getDueDate();
        this.group = source.getGroup();
    }
}