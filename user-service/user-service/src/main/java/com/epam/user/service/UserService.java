package com.epam.user.service;

import com.epam.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> listAllUsers();

    Optional<User> getUserById(int id);

    void removeUser(int id);

    User updateUser(int id, User user);
}
