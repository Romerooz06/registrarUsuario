package com.example.ejercicio.controller;

import com.example.ejercicio.service.UserService;
import com.example.ejercicio.service.dto.ResponseDTO;
import com.example.ejercicio.service.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private String token;
    private UserDTO user;
    private ResponseDTO response;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        token = "Bearer token";
        user = new UserDTO();
        response = new ResponseDTO();
    }

    @Test
    void registryUser_ShouldReturnCreatedResponse() throws Exception {
        when(userService.registryUser(anyString(), any(UserDTO.class))).thenReturn(response);

        ResponseDTO result = userController.registryUser(token, user);

        assertEquals(response, result);
    }
}
