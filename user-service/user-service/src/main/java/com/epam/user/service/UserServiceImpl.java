package com.epam.user.service;

import com.epam.user.entity.User;
import com.epam.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
        LOGGER.info("Inside get user by id in user service");
        return userRepository.findById(id);
    }

    @Override
    public void removeUser(int id) {
        LOGGER.info("Inside remove user in user service");
        Optional<User> user = userRepository.findById(id);
        userRepository.delete(user.get());
    }

    @Override
    public User updateUser(int id, User user) {
        LOGGER.info("Inside update user in user service");
        Optional<User> user1 = userRepository.findById(id);

        if (!user1.isPresent()){
            return user;
        }

        if(!"".equals(user.getUserName()) && user.getUserName() != null){
            user1.get().setUserName(user.getUserName());
        }
        if(!"".equals(user.getMail()) && user.getMail() != null){
            user1.get().setMail(user.getMail());
        }
        if(!"".equals(user.getPhoneNumber()) && user.getPhoneNumber() != null){
            user1.get().setPhoneNumber(user.getPhoneNumber());
        }
        return userRepository.save(user1.get());
    }
}
