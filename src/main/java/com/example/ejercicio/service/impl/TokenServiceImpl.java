package com.example.ejercicio.service.impl;

import com.example.ejercicio.config.Auth.JwtUtilService;
import com.example.ejercicio.config.Auth.model.AuthenticationReq;
import com.example.ejercicio.config.Auth.model.TokenInfo;
import com.example.ejercicio.controller.TokenController;
import com.example.ejercicio.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


@Component
public class TokenServiceImpl implements TokenService {
    @Autowired
    private JwtUtilService jwtUtilService;

    @Autowired
    UserDetailsService usuarioDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(TokenController.class);

    public ResponseEntity<TokenInfo> authenticate(AuthenticationReq authenticationReq) throws Exception {

        logger.info("Autenticando al usuario {}", authenticationReq.getUsuario());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationReq.getUsuario(),
                        authenticationReq.getClave()));

        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
                authenticationReq.getUsuario());

        final String jwt = jwtUtilService.generateToken(userDetails);

        return ResponseEntity.ok(new TokenInfo(jwt));

    }
}
