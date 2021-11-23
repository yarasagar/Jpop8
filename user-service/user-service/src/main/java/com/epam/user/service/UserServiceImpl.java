package com.epam.user.service;

import com.epam.user.entity.User;
import com.epam.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listAllUsers() {
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

        if(!"".equals(user.getUserName())){
            user1.setUserName(user.getUserName());
        }
        if(!"".equals(user.getMail())){
            user1.setMail(user.getMail());
        }
        if(!"".equals(user.getPhoneNumber())){
            user1.setPhoneNumber(user.getPhoneNumber());
        }
        return userRepository.save(user1);
    }
}
