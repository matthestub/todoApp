package com.mat.todo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SqlTasksGroupRepository extends TasksGroupRepository, JpaRepository<TasksGroup, Long> {

    @Override
    @Query("from TasksGroup g join fetch g.tasks")
    List<TasksGroup> findAll();
}
