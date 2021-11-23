package com.epam.user.controller;

import com.epam.user.entity.User;
import com.epam.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> listAllUsers(){
        return userService.listAllUsers();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") int id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void removeUser(@PathVariable("userId") int id){
        userService.removeUser(id);
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable("userId") int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

}
