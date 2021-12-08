package com.epam.user.controller;

import com.epam.user.entity.User;
import com.epam.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> listAllUsers(){
        return userService.listAllUsers();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") int id){
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User saveUser(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable("userId") int id){
        userService.removeUser(id);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable("userId") int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

}
