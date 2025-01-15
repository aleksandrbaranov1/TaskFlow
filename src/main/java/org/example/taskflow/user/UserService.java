package org.example.taskflow.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Autowired
//    public String getUser(Long id) {
//        return userRepository.getOne(id).toString();
//    }
}
