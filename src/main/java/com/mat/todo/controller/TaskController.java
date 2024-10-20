package com.mat.todo.controller;

import com.mat.todo.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RepositoryRestController(path = "/tasks")
public class TaskController {

    public static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository taskRepository;

    TaskController(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping(value = "/all", params = {"!size", "!sort", "!page"})
    ResponseEntity<?> readAllTasks() {
        logger.warn("Caution! Exposing all the tasks!");
        return ResponseEntity.ok(taskRepository.findAll());
    }
}
