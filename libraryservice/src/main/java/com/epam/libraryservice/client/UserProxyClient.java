package com.epam.libraryservice.client;

import com.epam.libraryservice.VO.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="USER-SERVICE", fallback = UserServiceFallBack.class)
public interface UserProxyClient {

    @GetMapping("/api/users/")
    ResponseEntity<User[]> getAllUsers();

    @GetMapping("/api/users/{user_id}")
    ResponseEntity<User> getUserById(@PathVariable("user_id") int userId);

    @PostMapping("/api/users/")
    ResponseEntity<User> addUser(User user);

    @DeleteMapping("/api/users/{user_id}")
    void deleteUser(@PathVariable("user_id") int userId);

    @PutMapping("/api/users/{user_id}")
    void updateUser(User user, @PathVariable("user_id") int userId);
}