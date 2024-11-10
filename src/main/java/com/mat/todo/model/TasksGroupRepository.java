package com.mat.todo.model;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TasksGroupRepository {

    List<TasksGroup> findAll();
    Optional<TasksGroup> findById(Long id);
    TasksGroup save(TasksGroup tasksGroup);
}