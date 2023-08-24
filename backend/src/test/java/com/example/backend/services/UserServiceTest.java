package com.example.backend.services;

import com.example.backend.models.StateModel;
import com.example.backend.models.UserModel;
import com.example.backend.repositories.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private UserModel user;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new UserModel();

        user.setId(4);
        user.setNombres("test4");
        user.setApellidos("test4");
        user.setLogin("login4");
        user.setState_id(new StateModel());
        user.setCreated(LocalDateTime.now());
        user.setLastUpdate(LocalDateTime.now());
        user.setEmail("test4@gmail.com");
        user.setPassword("password4");
    }

    @Test
    void getUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        Assert.assertNotNull(userService.getUsers());
    }
}