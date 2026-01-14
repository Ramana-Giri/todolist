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
    public void addTask(int id,String task) {
        Task taskObj = new Task();
        taskObj.setId(id);
        taskObj.setTask(task);
        taskRepository.save(taskObj);
    }

    // Update task
    public void updateTask(int id, String task) {
        Task taskObj = taskRepository.findById(id).orElseThrow();
        taskObj.setTask(task);
        taskRepository.save(taskObj);
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
        System.out.println("Task Deleted Successfully");
    }
}
