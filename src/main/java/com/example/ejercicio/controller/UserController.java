package com.example.ejercicio.controller;

import com.example.ejercicio.service.UserService;
import com.example.ejercicio.service.dto.ResponseDTO;
import com.example.ejercicio.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("registry")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO registryUser(@RequestHeader("Authorization") String token, @RequestBody UserDTO user) throws Exception {
        return userService.registryUser(token,user);
    }

}
