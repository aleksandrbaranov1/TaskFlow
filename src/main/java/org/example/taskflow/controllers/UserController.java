package org.example.taskflow.controllers;

import org.example.taskflow.repos.TaskRepository;
import org.example.taskflow.repos.UserRepository;
import org.example.taskflow.service.TaskService;
import org.example.taskflow.service.UserService;
import org.example.taskflow.user.Task;
import org.example.taskflow.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    private final TaskService taskService;

    @Autowired
    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @RequestMapping("/allTasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @RequestMapping("allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}/birthdate")
    public ResponseEntity<LocalDate> getUserBirthdate(@PathVariable Long id) {
        LocalDate userBirthday = userService.getUserBirthdayById(id);
        if(userBirthday == null) {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(userBirthday);
        }
    }
    @PostMapping("/createUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    @RequestMapping("/tasks")
    public List<String> tasks(){
        return List.of("task1", "task2", "task3", "task4");
    }
}
