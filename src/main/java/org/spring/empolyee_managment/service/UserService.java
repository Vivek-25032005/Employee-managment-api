package org.spring.empolyee_managment.service;

import org.spring.empolyee_managment.model.User;

public interface UserService {
    String registerUser(User user);
    String loginUser(User user);
}
