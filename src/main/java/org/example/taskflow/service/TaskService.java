package org.example.taskflow.service;

import jakarta.transaction.Transactional;
import org.example.taskflow.repos.TaskRepository;
import org.example.taskflow.user.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    @Transactional
    public void saveTask(Task task) {
        taskRepository.save(task);
    }
}
