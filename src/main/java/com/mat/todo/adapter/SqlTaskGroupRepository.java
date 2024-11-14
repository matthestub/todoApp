package com.mat.todo.adapter;

import com.mat.todo.model.TaskGroup;
import com.mat.todo.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SqlTaskGroupRepository extends TaskGroupRepository, JpaRepository<TaskGroup, Long> {

    @Override
    @Query("select distinct g from TaskGroup g join fetch g.tasks") //INNER JOIN by default, no TaskGroup if no Tasks found
    List<TaskGroup> findAll();

    @Override
    boolean existsByCompletedIsFalseAndProject_Id(Integer projectId);
}
