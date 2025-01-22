package org.example.taskflow.controllers;

import org.example.taskflow.repos.UserRepository;
import org.example.taskflow.service.UserService;
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
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @RequestMapping
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
