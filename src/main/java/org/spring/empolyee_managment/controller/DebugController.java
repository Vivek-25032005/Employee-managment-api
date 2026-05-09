package org.spring.empolyee_managment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.spring.empolyee_managment.entity.UserEntity;
import org.spring.empolyee_managment.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("debug")
@CrossOrigin(
    origins = "https://employee-managment-ui.vercel.app",
    allowedHeaders = "*"
)
public class DebugController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}