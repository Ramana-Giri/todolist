package com.example.controller;

import com.example.model.Task;
import com.example.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // CREATE
    @PostMapping("/add/task")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        return new ResponseEntity<Task>(taskService.addTask(task), HttpStatus.CREATED);
    }

    // READ
    @GetMapping("/task/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<List<Task>>(taskService.getAllTasks(), HttpStatus.OK);
    }

    // READ BY ID
    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id) {
        try {
            return new ResponseEntity<Task>(taskService.getTask(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE
    @PutMapping("update/task")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return new ResponseEntity<Task>(taskService.updateTask(task), HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/task/{id}")
    public void deleteTaskById(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
