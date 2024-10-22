package com.mat.todo.controller;

import com.mat.todo.model.Task;
import com.mat.todo.model.TaskRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

    public static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository taskRepository;

    TaskController(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping(value = "/all", params = {"!size", "!sort", "!page"})
    ResponseEntity<List<Task>> readAllTasks() {
        logger.warn("Caution! Exposing all the tasks!");
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @GetMapping(value = "/all")
    ResponseEntity<Page<Task>> readAllTasks(Pageable pageable) {
        logger.warn("Caution! Exposing all the tasks!");
        return ResponseEntity.ok(taskRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    ResponseEntity<Task> readTask(@PathVariable int id) {
        return taskRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<?> insertTask(@RequestBody @Valid Task toInsert) throws URISyntaxException {
        Task savedTask = taskRepository.save(toInsert);
        URI uri = new URI("/tasks/"+savedTask.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Task toUpdate) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        taskRepository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
}