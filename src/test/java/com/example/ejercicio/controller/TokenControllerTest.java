package com.example.ejercicio.controller;

import com.example.ejercicio.config.Auth.model.AuthenticationReq;
import com.example.ejercicio.config.Auth.model.TokenInfo;
import com.example.ejercicio.service.TokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TokenControllerTest {

    @Mock
    private TokenService tokenService;

    @InjectMocks
    private TokenController tokenController;

    private AuthenticationReq authenticationReq;
    private TokenInfo tokenInfo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authenticationReq = new AuthenticationReq();
        tokenInfo = new TokenInfo("a");
    }

    @Test
    void authenticate_ShouldReturnTokenInfo() throws Exception {
        when(tokenService.authenticate(any(AuthenticationReq.class))).thenReturn(ResponseEntity.ok(tokenInfo));

        ResponseEntity<TokenInfo> result = tokenController.authenticate(authenticationReq);

        assertEquals(ResponseEntity.ok(tokenInfo), result);
    }
}
