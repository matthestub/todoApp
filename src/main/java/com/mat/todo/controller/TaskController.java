package com.mat.todo.controller;

import com.mat.todo.model.Task;
import com.mat.todo.model.TaskRepository;
import jakarta.transaction.Transactional;
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

    public static final String CAUTION_MSG = "Caution! Exposing all the tasks!";
    public static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    private final TaskRepository taskRepository;

    TaskController(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping(value = "/all", params = {"!size", "!sort", "!page"})
    ResponseEntity<List<Task>> readAllTasks() {
        logger.warn(CAUTION_MSG);
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @GetMapping(value = "/all")
    ResponseEntity<Page<Task>> readAllTasks(Pageable pageable) {
        logger.warn(CAUTION_MSG);
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

    @Transactional
    @PutMapping("/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Task toUpdate) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.findById(id)
                .ifPresent(task -> task.updateFrom(toUpdate));
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<?> toggleTask(@PathVariable int id) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.findById(id)
                .ifPresent(task -> task.setDone(!task.isDone()));
        return ResponseEntity.noContent().build();
    }
}