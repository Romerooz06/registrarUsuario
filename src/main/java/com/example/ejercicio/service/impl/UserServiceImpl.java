package com.example.ejercicio.service.impl;

import com.example.ejercicio.service.UserService;
import com.example.ejercicio.service.dto.ResponseDTO;
import com.example.ejercicio.service.dto.UserDTO;
import com.example.ejercicio.service.dto.mapper.UserMapper;
import com.example.ejercicio.utils.Utils;
import com.example.ejercicio.model.User;
import com.example.ejercicio.repository.UserRepository;
import com.example.ejercicio.utils.enums.ExceptionMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Utils utils;

    public ResponseDTO registryUser(String token, UserDTO userDTO) throws Exception {
        if (!utils.validateEmail(userDTO.getEmail())) {
            throw new Exception(ExceptionMessages.INVALID_EMAIL.getMessage());
        }
        if (!utils.validatePassword(userDTO.getPassword())) {
            throw new Exception(ExceptionMessages.INVALID_PASS.getMessage());
        }
        Optional<User> email = userRepository.findByEmail(userDTO.getEmail());
        if (email.isPresent()) {
            throw new Exception(ExceptionMessages.EXISTING_EMAIL.getMessage());
        }
        User userMapped = UserMapper.mapper.toModelFromDto(userDTO);
        userMapped.setToken(token);
        User insertResponse;
        try{
            insertResponse = userRepository.save(userMapped);
        }catch(Exception e){
            throw new Exception(ExceptionMessages.INSERT_DB_ERROR.getMessage());
        }
        return UserMapper.mapper.toResponseDTOFromModel(insertResponse);
    }
}
