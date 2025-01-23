package org.example.taskflow.service;

import jakarta.transaction.Transactional;
import org.example.taskflow.repos.TaskRepository;
import org.example.taskflow.repos.UserRepository;
import org.example.taskflow.user.Task;
import org.example.taskflow.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    public TaskService(TaskRepository taskRepository, UserRepository userRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;

    }
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }
    @Transactional
    public void saveTask(Task task) {
        taskRepository.save(task);
    }
    public List<String> getTasksByUserId(Long userId) {
        return taskRepository.findContentByUserId(userId);
    }
}
