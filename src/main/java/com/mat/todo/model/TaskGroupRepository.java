package com.mat.todo.model;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskGroupRepository {

    List<TaskGroup> findAll();
    Optional<TaskGroup> findById(Long id);
    TaskGroup save(TaskGroup taskGroup);
}