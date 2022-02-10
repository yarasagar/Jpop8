package com.epam.libraryservice.controller;

import com.epam.libraryservice.VO.User;
import com.epam.libraryservice.service.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/library/users")
public class LibraryUserController {

    @Autowired
    private LibraryUserService libraryUserService;

    @GetMapping("/")
    public ResponseEntity<User[]> getListOfAllUsers(){
        return libraryUserService.getListOfAllUsers();
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<User> getUser(@PathVariable("user_id") int userId){
        return libraryUserService.getUser(userId);
    }

    @PostMapping("/")
    public ResponseEntity<User> postUser(@RequestBody User user){
        return libraryUserService.postUser(user);
    }

    @PutMapping("/{user_id}")
    public void updateUser(@RequestBody User user, @PathVariable("user_id") int userId){
        libraryUserService.updateUser(user, userId);
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable("user_id") int userId){
        libraryUserService.deleteUser(userId);
    }

}
