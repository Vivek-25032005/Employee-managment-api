package org.spring.empolyee_managment.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.spring.empolyee_managment.entity.UserEntity;
import org.spring.empolyee_managment.model.User;
import org.spring.empolyee_managment.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String registerUser(User user) {
        Optional<UserEntity> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return "Email already exists";
        }

        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(user, entity);

        userRepository.save(entity);
        return "User registered successfully";
    }

    @Override
    public String loginUser(User user) {
        Optional<UserEntity> existingUser = Optional.empty();
        if (user.getEmail() != null && !user.getEmail().isBlank()) {
            existingUser = userRepository.findByEmail(user.getEmail());
        }
        if (existingUser.isEmpty() && user.getName() != null && !user.getName().isBlank()) {
            existingUser = userRepository.findByName(user.getName());
        }

        if (existingUser.isEmpty()) {
            return "Invalid email/name or password";
        }

        UserEntity entity = existingUser.get();
        if (!entity.getPassword().equals(user.getPassword())) {
            return "Invalid email/name or password";
        }

        return "Login successful";
    }
}
