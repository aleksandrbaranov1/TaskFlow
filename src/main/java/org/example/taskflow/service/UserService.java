package org.example.taskflow.service;

import org.example.taskflow.repos.UserRepository;
import org.example.taskflow.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public LocalDate getUserBirthdayById(Long id){
        return userRepository.findById(id)
                .map(User::getBirthday)
                .orElse(null);
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElse(null);
    }


}
