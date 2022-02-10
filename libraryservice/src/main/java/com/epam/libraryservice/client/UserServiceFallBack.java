package com.epam.libraryservice.client;

import com.epam.libraryservice.VO.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallBack implements UserProxyClient {

    @Override
    public ResponseEntity<User[]> getAllUsers() {
        System.out.println("user service is down");
        User user = User
                .builder()
                .userId(0)
                .userName("defaultName")
                .mail("defaultMail")
                .phoneNumber("defaultPhone")
                .build();
        User[] users = new User[1];
        users[0] = user;
        ResponseEntity<User[]> out = new ResponseEntity<User[]>(users, HttpStatus.ACCEPTED);
        return out;
    }

    @Override
    public ResponseEntity<User> getUserById(int userId) {
        System.out.println("user service is down");
        User user = User
                .builder()
                .userId(0)
                .userName("defaultName")
                .mail("defaultMail")
                .phoneNumber("defaultPhone")
                .build();
        ResponseEntity<User> out = new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
        return out;
    }

    @Override
    public ResponseEntity<User> addUser(User user) {
        System.out.println("user service is down");
        ResponseEntity<User> out = new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
        return out;
    }

    @Override
    public void deleteUser(int userId) {
        System.out.println("user service is down");
    }

    @Override
    public void updateUser(User user, int userId) {
        System.out.println("user service is down");
    }

}
