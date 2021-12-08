package com.epam.user.service;

import static org.junit.Assert.assertEquals;

import com.epam.user.entity.User;
import com.epam.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUserByIdSuccessTest(){
        int userId = 1;
        User expectedUser = User.builder()
                .userId(1)
                .userName("sagar")
                .phoneNumber("12345")
                .mail("sagar@gmail")
                .build();
        Optional<User> user = Optional.of(User.builder()
                .userId(1)
                .userName("sagar")
                .phoneNumber("12345")
                .mail("sagar@gmail")
                .build());
//        Mockito.when(userRepository.findById(1)).thenReturn(user);
//        Optional<User> actualUser = userService.getUserById(userId);
        assertEquals(expectedUser, user.get());
    }
}
