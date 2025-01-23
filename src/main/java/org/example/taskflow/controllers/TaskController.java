package org.example.taskflow.controllers;

import org.example.taskflow.service.TaskService;
import org.example.taskflow.service.UserService;
import org.example.taskflow.user.Task;
import org.example.taskflow.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @PostMapping("/user/tasks/new")
    public ResponseEntity<String> addTask(
            @RequestParam String content,
            @RequestParam Long userId
    ) {
        User user = userService.getUserById(userId);
        if(user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("User with ID" + userId+ "not found");
        }
        Task task = new Task();
        task.setContent(content);
        task.setUser(user);
        taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Задача успешно добавлена");
    }
    // /user/{userId}/tasks - все таски пользователя
    // /user/{userId}/tasks/{taskId} - определенная таска определенного пользователя

//    @GetMapping("/user/{userId}/tasks")
//    public ResponseEntity<List<Task>>

}
