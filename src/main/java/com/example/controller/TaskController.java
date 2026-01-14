package com.example.controller;

import com.example.model.Task;
import com.example.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/add/task")
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task.getId(), task.getTask());
    }

    @PutMapping("update/task")
    public void updateTask(@RequestBody Task task) {
        taskService.updateTask(task.getId(), task.getTask());
    }

    @GetMapping("/task/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/task/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.getTask(id);
    }

    @DeleteMapping("/task/{id}")
    public void deleteTaskById(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
