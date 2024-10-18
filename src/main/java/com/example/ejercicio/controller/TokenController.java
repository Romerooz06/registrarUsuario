package com.example.ejercicio.controller;

import com.example.ejercicio.config.Auth.model.AuthenticationReq;
import com.example.ejercicio.config.Auth.model.TokenInfo;
import com.example.ejercicio.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TokenController {

   @Autowired
   private TokenService tokenService;

    @PostMapping("publico/authenticate")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthenticationReq authenticationReq) throws Exception {
        return tokenService.authenticate(authenticationReq);
    }

}
