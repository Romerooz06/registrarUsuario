package com.example.ejercicio.service;

import com.example.ejercicio.service.dto.ResponseDTO;
import com.example.ejercicio.service.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    public ResponseDTO registryUser(String token, UserDTO userDTO) throws Exception;
}
