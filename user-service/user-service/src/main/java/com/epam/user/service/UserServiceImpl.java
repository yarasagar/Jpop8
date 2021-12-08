package com.epam.user.service;

import com.epam.user.entity.User;
import com.epam.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listAllUsers() {
        LOGGER.info("Inside list all users service");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void removeUser(int id) {
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.get());
    }

    @Override
    public User updateUser(int id, User user) {
        User user1 = userRepository.getById(id);

        if(!"".equals(user.getUserName()) && user.getUserName() != null){
            user1.setUserName(user.getUserName());
        }
        if(!"".equals(user.getMail()) && user.getMail() != null){
            user1.setMail(user.getMail());
        }
        if(!"".equals(user.getPhoneNumber()) && user.getPhoneNumber() != null){
            user1.setPhoneNumber(user.getPhoneNumber());
        }
        return userRepository.save(user1);
    }
}
