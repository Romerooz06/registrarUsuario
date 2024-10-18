package com.example.ejercicio.service.impl;

import com.example.ejercicio.config.Auth.JwtUtilService;
import com.example.ejercicio.config.Auth.model.AuthenticationReq;
import com.example.ejercicio.config.Auth.model.TokenInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TokenServiceImplTest {

    @Mock
    private JwtUtilService jwtUtilService;

    @Mock
    private UserDetailsService usuarioDetailsService;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private TokenServiceImpl tokenServiceImpl;

    private AuthenticationReq authenticationReq;
    private TokenInfo tokenInfo;
    private UserDetails userDetails;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authenticationReq = new AuthenticationReq();
        authenticationReq.setUsuario("testUser");
        authenticationReq.setClave("testPassword");
        tokenInfo = new TokenInfo("testToken");
        userDetails = org.mockito.Mockito.mock(UserDetails.class);
    }

    @Test
    void authenticate_ShouldReturnTokenInfo() throws Exception {
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(null);
        when(usuarioDetailsService.loadUserByUsername(any(String.class))).thenReturn(userDetails);
        when(jwtUtilService.generateToken(userDetails)).thenReturn("testToken");

        ResponseEntity<TokenInfo> result = tokenServiceImpl.authenticate(authenticationReq);

        assertEquals(ResponseEntity.ok(tokenInfo), result);
    }
}
