package com.epam.libraryservice.service;

import com.epam.libraryservice.VO.User;
import com.epam.libraryservice.client.UserProxyClient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibraryUserService {

    private static Logger LOGGER = LoggerFactory.getLogger(LibraryUserService.class);
//    @Autowired
  //  private RestTemplate restTemplate;

    @Autowired
    private UserProxyClient userProxyClient;

    public ResponseEntity<User[]> getListOfAllUsers() {
        try{
            LOGGER.info("Library user service is started");
            return userProxyClient.getAllUsers();
        }catch (FeignException e){
            e.printStackTrace();
            return new ResponseEntity<User[]>(new User[0], HttpStatus.ACCEPTED);
        }
        //For user USER-SERVICE, need to add @LoadBalanced annotation for restTemplate
//        return restTemplate.getForEntity("http://USER-SERVICE/api/users/", User[].class);
//        return restTemplate.getForEntity("http://localhost:9003/api/users/", User[].class);
    }

    public ResponseEntity<User> getUser(int userId) {
        LOGGER.info("Inside get user in library user service");
        return userProxyClient.getUserById(userId);
//        return restTemplate.getForEntity("http://USER-SERVICE/api/users/"+userId, User.class);
//        return restTemplate.getForEntity("http://localhost:9003/api/users/"+userId, User.class);
    }

    public ResponseEntity<User> postUser(User user) {
        LOGGER.info("Inside add user in library user service");
        return userProxyClient.addUser(user);
//        return restTemplate.postForEntity("http://localhost:9003/api/users/", user, User.class);
    }

    public void deleteUser(int userId) {
        LOGGER.info("Inside remove user in library user service");
        userProxyClient.deleteUser(userId);
//        restTemplate.delete("http://localhost:9003/api/users/"+userId);
    }

    public void updateUser(User user, int userId) {
        LOGGER.info("Inside update user in library user service");
        userProxyClient.updateUser(user, userId);
//        restTemplate.put("http://localhost:9003/api/users/"+userId, user);
    }

}
