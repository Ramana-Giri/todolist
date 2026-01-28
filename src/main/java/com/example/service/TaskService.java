package com.example.service;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    TaskRepository taskRepository;

    // Create task
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    // Update task
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    // Read All Tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Read Task by Id
    public Task getTask(int id) {
        return taskRepository.findById(id).orElseThrow();
    }

    // Delete Task
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
