package com.mat.todo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Override
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Task entity);

    @RestResource(path = "done")
    List<Task> findByDone(@Param("state") boolean isDone);
}