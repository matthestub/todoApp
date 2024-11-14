package com.mat.todo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Project's description must not be null or empty!")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<ProjectStep> steps;
    @OneToMany(mappedBy = "project")
    private Set<TaskGroup> groups;

    public Project() {
    }

    public int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    Set<ProjectStep> getSteps() {
        return steps;
    }

    void setSteps(final Set<ProjectStep> steps) {
        this.steps = steps;
    }

    Set<TaskGroup> getGroups() {
        return groups;
    }

    void setGroups(final Set<TaskGroup> groups) {
        this.groups = groups;
    }
}
