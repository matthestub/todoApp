package com.mat.todo.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();
    Page<Task> findAll(Pageable pageable);
    Optional<Task> findById(Integer id);
    List<Task> findByDone(@Param("state") boolean done);
    boolean existsById(Integer id);
    Task save(Task entity);
}