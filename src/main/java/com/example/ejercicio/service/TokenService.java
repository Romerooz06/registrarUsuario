package com.example.ejercicio.service;

import com.example.ejercicio.config.Auth.model.AuthenticationReq;
import com.example.ejercicio.config.Auth.model.TokenInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface TokenService {
    public ResponseEntity<TokenInfo> authenticate(AuthenticationReq authenticationReq) throws Exception;
}
