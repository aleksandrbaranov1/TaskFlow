package org.example.taskflow.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String home(@RequestParam(value = "id", defaultValue = "0") Long userId) {
       if(userId <= 0){
           return "hello Guest!";
       }
        return userRepository.findById(userId)
                .map(user -> "Hello " + user.getName() + "!")
                .orElse("User not found!");
    }

    @RequestMapping("/tasks")
    public List<String> tasks(){
        return List.of("task1", "task2", "task3", "task4");
    }
}
