package com.example.ejercicio.service.impl;

import com.example.ejercicio.service.dto.ResponseDTO;
import com.example.ejercicio.service.dto.UserDTO;
import com.example.ejercicio.service.dto.mapper.UserMapper;
import com.example.ejercicio.utils.Utils;
import com.example.ejercicio.model.User;
import com.example.ejercicio.repository.UserRepository;
import com.example.ejercicio.utils.enums.ExceptionMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private Utils utils;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    private UserDTO userDTO;
    private ResponseDTO responseDTO;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userDTO = new UserDTO();
        userDTO.setEmail("test@example.com");
        userDTO.setPassword("ValidPassword123");
        responseDTO = new ResponseDTO();
        user = new User();
    }

    @Test
    void registryUser_ShouldReturnResponseDTO() throws Exception {
        when(utils.validateEmail(anyString())).thenReturn(true);
        when(utils.validatePassword(anyString())).thenReturn(true);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(userMapper.toModelFromDto(any(UserDTO.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userMapper.toResponseDTOFromModel(any(User.class))).thenReturn(responseDTO);

        ResponseDTO result = userServiceImpl.registryUser("Bearer token", userDTO);

        assertNotNull(result);
    }

    @Test
    void registryUser_ShouldThrowExceptionForInvalidPassword() {
        when(utils.validateEmail(anyString())).thenReturn(true);
        when(utils.validatePassword(anyString())).thenReturn(false);

        Exception exception = assertThrows(Exception.class, () -> {
            userServiceImpl.registryUser("Bearer token", userDTO);
        });

        assertEquals(ExceptionMessages.INVALID_PASS.getMessage(), exception.getMessage());
    }

    @Test
    void registryUser_ShouldThrowExceptionForExistingEmail() {
        when(utils.validateEmail(anyString())).thenReturn(true);
        when(utils.validatePassword(anyString())).thenReturn(true);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));

        Exception exception = assertThrows(Exception.class, () -> {
            userServiceImpl.registryUser("Bearer token", userDTO);
        });

        assertEquals(ExceptionMessages.EXISTING_EMAIL.getMessage(), exception.getMessage());
    }
}
